package com.saranganrajan.apps.coredomainprocessor.service.policy;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface PolicyService {
    public List<PolicyEntity> getAllPolicies() throws SQLException;
}
