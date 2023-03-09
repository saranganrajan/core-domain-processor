package com.saranganrajan.apps.coredomainprocessor.external.domain.feign;

import com.saranganrajan.apps.coredomainprocessor.dto.PolicyAggregate;
import com.saranganrajan.apps.coredomainprocessor.dto.PolicyTransaction;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyTransactionEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="ahmf-manager", url="http://localhost:8086")
public interface AHMFFeignClient {
    @PostMapping(path = "/manager/audit/save", produces = "application/json")
    ResponseEntity<List<PolicyTransactionEntity>> saveTransactions(@RequestBody List<PolicyTransactionEntity> policyTransactions);
}
