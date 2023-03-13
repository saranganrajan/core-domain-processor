package com.saranganrajan.apps.coredomainprocessor.service.manager;

import com.google.gson.Gson;
import com.saranganrajan.apps.coredomainprocessor.dto.*;
import com.saranganrajan.apps.coredomainprocessor.dto.mapper.PolicyMapper;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentHistoryEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyTransactionEntity;
import com.saranganrajan.apps.coredomainprocessor.external.domain.feign.AHMFFeignClient;
import com.saranganrajan.apps.coredomainprocessor.external.domain.feign.DomainFeignClient;
import com.saranganrajan.apps.coredomainprocessor.handler.AggregateHandler;
import com.saranganrajan.apps.coredomainprocessor.service.customer.CustomerService;
import com.saranganrajan.apps.coredomainprocessor.service.policy.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ManagerServiceImpl implements ManagerService {

    PolicyService policyService;
    CustomerService customerService;
    AggregateHandler aggregateHandler;
    DomainFeignClient domainFeignClient;
    AHMFFeignClient ahmfFeignClient;

    @Autowired
    public ManagerServiceImpl(PolicyService policyService,
                              CustomerService customerService,
                              AggregateHandler aggregateHandler,
                              DomainFeignClient domainFeignClient,
                              AHMFFeignClient ahmfFeignClient) {
        this.policyService = policyService;
        this.customerService = customerService;
        this.aggregateHandler = aggregateHandler;
        this.domainFeignClient = domainFeignClient;
        this.ahmfFeignClient = ahmfFeignClient;
    }

    @Override
    @Transactional
    public void processTransactions(List<PolicyTransaction> policyTransactions) {
        if (!CollectionUtils.isEmpty(policyTransactions)) {
            List<PolicyTransactionEntity> policyTransactionEntities = saveTransactions(policyTransactions);
            manageTransactions(policyTransactionEntities);
        }
    }

    public void manageTransactions(List<PolicyTransactionEntity> policyTransactions) {
        policyTransactions.forEach(policyTransaction -> {
            log.info("Processing policy : " + policyTransaction.getPolicyNumber());
            Optional<PolicyEntity> policyEntity = policyService.getPolicyInformation(policyTransaction.getPolicyNumber());
            if (policyEntity.isPresent()) {
                PolicyEntity maybePolicy = policyEntity.get();
                //Update Policy
                updatePolicy(policyTransaction, maybePolicy);
                //get Payment History
                updatePayment(policyTransaction);
                //Form PolicyAggregate
                try {

                    List<CustomerPolicy> customerPolicies = aggregateHandler.prepareCustomerPolicyObject(maybePolicy);
                    List<Customer> customers = aggregateHandler.prepareCustomers(customerPolicies);
                    customers.stream().forEach(customer -> {
                        customer.setCustomerTransactionId(UUID.randomUUID().toString());
                    });
                    PolicyAggregate policyAggregate = PolicyAggregate.builder()
                            .policy(aggregateHandler.preparePolicyObject(maybePolicy, policyTransaction.getPolicyTransactionId()))
                            .customerPolicies(customerPolicies)
                            .customers(customers)
                            .build();
                    log.info(policyAggregate.toString());
                    String policyAggregateString =new Gson().toJson(policyAggregate);
                    domainFeignClient.processPolicyTransaction(policyAggregate);
                } catch (SQLException sqlException) {
                    log.error(sqlException.getLocalizedMessage());
                }
            }
        });
    }

    private void updatePayment(PolicyTransactionEntity policyTransaction) {
        PaymentHistoryEntity paymentHistoryEntity = PaymentHistoryEntity.builder()
                .policyNumber(policyTransaction.getPolicyNumber())
                .paymentDate(policyTransaction.getPaymentDate())
                .paymentMode(policyTransaction.getPaymentMode())
                .paymentAmount(policyTransaction.getPremiumPaid())
                .build();
        //Update Payment History
        //paymentService.savePayment(paymentHistoryEntity);
        log.info("Updated Policy Payment : " + policyTransaction.getPolicyNumber());
    }

    private void updatePolicy(PolicyTransactionEntity policyTransaction, PolicyEntity policyEntity) {
        PolicyEntity maybePolicyEntity = policyEntity;
        maybePolicyEntity.setLastPaymentMode(policyTransaction.getPaymentMode());
        maybePolicyEntity.setPremiumPaid(maybePolicyEntity.getPremiumPaid() - policyTransaction.getPremiumPaid());
        maybePolicyEntity.setPremiumDue(maybePolicyEntity.getPremiumDue() + policyTransaction.getPremiumPaid());
        //policyService.savePolicy(maybePolicyEntity);
        log.info("Updated Policy Transaction : " + policyTransaction.getPolicyNumber());
    }

    private List<PolicyTransactionEntity> saveTransactions(List<PolicyTransaction> policyTransactions) {
        policyTransactions.forEach(policyTransaction -> {
            policyTransaction.setStatus(ProcessStatus.PENDING.name());
        });
        List<PolicyTransactionEntity> policyTransactionEntities = new ArrayList<>();
        policyTransactions.forEach(policyTransaction -> {
            policyTransactionEntities.add(PolicyMapper.INSTANCE.policyTransactionDtoToEntity(policyTransaction));
        });

       // ResponseEntity<List<PolicyTransactionEntity>> listResponseEntity =  ahmfFeignClient.saveTransactions(policyTransactionEntities);
        return policyTransactionEntities;
        //return listResponseEntity.getBody();
    }
}
