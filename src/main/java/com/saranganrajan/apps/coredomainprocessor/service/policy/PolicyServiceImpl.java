package com.saranganrajan.apps.coredomainprocessor.service.policy;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerPolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyStatusEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.CustomerPolicyRepository;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.PolicyRepository;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.PolicyStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private PolicyStatusRepository policyStatusRepository;

    @Autowired
    private CustomerPolicyRepository customerPolicyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository,
                             PolicyStatusRepository policyStatusRepository,
                             CustomerPolicyRepository customerPolicyRepository) {
        this.policyRepository = policyRepository;
        this.policyStatusRepository = policyStatusRepository;
        this.customerPolicyRepository = customerPolicyRepository;
    }

    @Override
    public List<PolicyEntity> getAllPolicies() throws SQLException {
            return policyRepository.findAll();
    }

    @Override
    public List<PolicyStatusEntity> getPolicyStatuses() throws SQLException {
        return policyStatusRepository.findAll();
    }

    @Override
    public List<CustomerPolicyEntity> getCustomersByPolicy(String policyNumber) throws SQLException {
        return customerPolicyRepository.findCustomerPolicyByPolicyNumber(policyNumber);
    }

    @Override
    public Optional<PolicyEntity> getPolicyInformation(String policyNumber) {
        return policyRepository.findById(policyNumber);
    }

    @Override
    public PolicyEntity savePolicy(PolicyEntity policyEntity) {
        return policyRepository.save(policyEntity);
    }

    @Override
    public Optional<PolicyStatusEntity> getPolicyStatusByCode(String code) {
       return policyStatusRepository.findById(code);
    }
}
