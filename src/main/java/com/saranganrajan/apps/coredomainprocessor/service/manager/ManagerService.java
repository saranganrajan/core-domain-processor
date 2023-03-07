package com.saranganrajan.apps.coredomainprocessor.service.manager;

import com.saranganrajan.apps.coredomainprocessor.dto.PolicyTransaction;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyTransactionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {
    void processTransactions(List<PolicyTransaction> policyTransactions);
    void manageTransactions(List<PolicyTransactionEntity> policyTransactions);
}
