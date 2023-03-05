package com.saranganrajan.apps.coredomainprocessor.service.manager;

import com.saranganrajan.apps.coredomainprocessor.dto.CustomerPolicy;
import com.saranganrajan.apps.coredomainprocessor.dto.Policy;
import com.saranganrajan.apps.coredomainprocessor.dto.PolicyAggregate;
import com.saranganrajan.apps.coredomainprocessor.dto.PolicyTransaction;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentHistoryEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.domain.feign.DomainFeignClient;
import com.saranganrajan.apps.coredomainprocessor.handler.AggregateHandler;
import com.saranganrajan.apps.coredomainprocessor.service.agent.AgentService;
import com.saranganrajan.apps.coredomainprocessor.service.customer.CustomerService;
import com.saranganrajan.apps.coredomainprocessor.service.payment.PaymentService;
import com.saranganrajan.apps.coredomainprocessor.service.policy.PolicyService;
import com.saranganrajan.apps.coredomainprocessor.service.product.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ManagerServiceImpl implements ManagerService {

    PolicyService policyService;
    CustomerService customerService;
    PlanService planService;
    AgentService agentService;
    PaymentService paymentService;
    AggregateHandler aggregateHandler;
    DomainFeignClient domainFeignClient;

    @Autowired
    public ManagerServiceImpl(PolicyService policyService,
                              CustomerService customerService,
                              PlanService planService,
                              AgentService agentService,
                              PaymentService paymentService,
                              AggregateHandler aggregateHandler,
                              DomainFeignClient domainFeignClient) {
        this.policyService = policyService;
        this.customerService = customerService;
        this.planService = planService;
        this.agentService = agentService;
        this.paymentService = paymentService;
        this.aggregateHandler = aggregateHandler;
        this.domainFeignClient = domainFeignClient;
    }

    @Override
    @Transactional
    public void processTransactions(List<PolicyTransaction> policyTransactions) {
        if (!CollectionUtils.isEmpty(policyTransactions)) {
            policyTransactions.forEach(policyTransaction -> {
                log.info("Processing policy : " + policyTransaction.getPolicyNumber());
                Optional<PolicyEntity> policyEntity = policyService.getPolicyInformation(policyTransaction.getPolicyNumber());
                if (policyEntity.isPresent()) {
                    //Update Policy
                    updatePolicy(policyTransaction, policyEntity.get());
                    //get Payment History
                    updatePayment(policyTransaction);
                    //Form PolicyAggregate
                    try {
                        List<CustomerPolicy> customerPolicies = aggregateHandler.prepareCustomerPolicyObject(policyEntity.get());
                        PolicyAggregate policyAggregate = PolicyAggregate.builder()
                                .policy(aggregateHandler.preparePolicyObject(policyEntity.get()))
                                .customerPolicies(customerPolicies)
                                .customers(aggregateHandler.prepareCustomers(customerPolicies))
                                .build();
                        log.info(policyAggregate.toString());
                        domainFeignClient.processPolicyTransaction(policyAggregate);
                    } catch (SQLException sqlException) {
                       log.error(sqlException.getLocalizedMessage());
                    }
                }
            });
        }
    }

    private void updatePayment(PolicyTransaction policyTransaction) {
        PaymentHistoryEntity paymentHistoryEntity = PaymentHistoryEntity.builder()
                .policyNumber(policyTransaction.getPolicyNumber())
                .paymentDate(policyTransaction.getPaymentDate())
                .paymentMode(policyTransaction.getPaymentMode())
                .paymentAmount(policyTransaction.getPremiumPaid())
                .build();
        //Update Payment History
        paymentService.savePayment(paymentHistoryEntity);
        log.info("Updated Policy Payment : " + policyTransaction.getPolicyNumber());
    }

    private void updatePolicy(PolicyTransaction policyTransaction, PolicyEntity policyEntity) {
        PolicyEntity maybePolicyEntity = policyEntity;
        maybePolicyEntity.setLastPaymentMode(policyTransaction.getPaymentMode());
        maybePolicyEntity.setPremiumPaid(maybePolicyEntity.getPremiumPaid() - policyTransaction.getPremiumPaid());
        maybePolicyEntity.setPremiumDue(maybePolicyEntity.getPremiumDue() + policyTransaction.getPremiumPaid());
        policyService.savePolicy(maybePolicyEntity);
        log.info("Updated Policy Transaction : " + policyTransaction.getPolicyNumber());
    }
}
