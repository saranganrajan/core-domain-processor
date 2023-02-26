package com.saranganrajan.apps.coredomainprocessor.service.policy;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public List<PolicyEntity> getAllPolicies() throws SQLException {
            return policyRepository.findAll();
    }
}
