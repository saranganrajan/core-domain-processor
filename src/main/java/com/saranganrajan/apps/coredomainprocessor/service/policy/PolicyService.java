package com.saranganrajan.apps.coredomainprocessor.service.policy;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerPolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyStatusEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface PolicyService {
    List<PolicyEntity> getAllPolicies() throws SQLException;
    List<PolicyStatusEntity> getPolicyStatuses() throws SQLException;
    Optional<CustomerPolicyEntity> getCustomerPolicies(String policyNumber) throws SQLException;
    Optional<PolicyEntity> getPolicyInformation(String policyNumber);
    PolicyEntity savePolicy(PolicyEntity policyEntity);
}
