package com.saranganrajan.apps.coredomainprocessor.handler;

import com.saranganrajan.apps.coredomainprocessor.dto.Customer;
import com.saranganrajan.apps.coredomainprocessor.dto.CustomerPolicy;
import com.saranganrajan.apps.coredomainprocessor.dto.Policy;
import com.saranganrajan.apps.coredomainprocessor.dto.PolicyStatus;
import com.saranganrajan.apps.coredomainprocessor.dto.mapper.CustomerAgentMapper;
import com.saranganrajan.apps.coredomainprocessor.dto.mapper.PolicyMapper;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerPolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.service.agent.AgentService;
import com.saranganrajan.apps.coredomainprocessor.service.customer.CustomerService;
import com.saranganrajan.apps.coredomainprocessor.service.payment.PaymentService;
import com.saranganrajan.apps.coredomainprocessor.service.policy.PolicyService;
import com.saranganrajan.apps.coredomainprocessor.service.product.PlanService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AggregateHandler {

    @Autowired
    AgentService agentService;

    @Autowired
    PlanService planService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    PolicyService policyService;

    @Autowired
    CustomerService customerService;


    public Policy preparePolicyObject(PolicyEntity policyEntity, String policyTransactionId) {
        Policy policy = PolicyMapper.INSTANCE.policyEntityToDto(policyEntity);
        policy.setPolicyTransactionId(policyTransactionId);
        policy.setAgentName(agentService.getAgentById(policyEntity.getAgentCode()).get().getAgentName());
        policy.setPlan(planService.getPlanById(policyEntity.getPlanCode()).get().getPlanDescription());
        policy.setPaymentMode(paymentService.getPaymentModeByCode(policyEntity.getLastPaymentMode()).get().getDescription());
        policy.setStatus(policyService.getPolicyStatusByCode(policyEntity.getPolicyStatusCode()).get().getDescription());
        return policy;
    }

    public List<CustomerPolicy> prepareCustomerPolicyObject(PolicyEntity policyEntity) throws SQLException {
        List<CustomerPolicyEntity> customerPolicyEntities = policyService.getCustomersByPolicy(policyEntity.getPolicyNumber());
        return PolicyMapper.INSTANCE.customerPolicyEntitiesToDtos(customerPolicyEntities);
    }

    public List<Customer> prepareCustomers(List<CustomerPolicy> customerPolicies) {
        CustomerAgentMapper MAPPER = Mappers.getMapper(CustomerAgentMapper.class);
        return customerPolicies.stream()
                .map(e -> customerService.getCustomerById(e.getCustomerNumber()).get())
                .map(MAPPER::customerEntityToDto)
                .collect(Collectors.toList());
    }
}
