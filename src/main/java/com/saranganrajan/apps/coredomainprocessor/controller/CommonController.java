package com.saranganrajan.apps.coredomainprocessor.controller;

import com.saranganrajan.apps.coredomainprocessor.dto.PolicyTransaction;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.service.customer.CustomerService;
import com.saranganrajan.apps.coredomainprocessor.service.policy.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@RestController
public class CommonController {

    @Autowired
    PolicyService policyService;

    @Autowired
    CustomerService customerService;

    public CommonController(PolicyService policyService, CustomerService customerService) {
        this.policyService = policyService;
        this.customerService = customerService;
    }

    @PostMapping(path = "/policy/premium/pay", consumes = "application/json")
    public ResponseEntity<String> processPolicy(@RequestBody List<PolicyTransaction> policies) {
        return ResponseEntity.ok().body(policies.get(0).getPolicyNumber());
    }

    @GetMapping
    public String getPolicy(String policyNumber) {
        return policyNumber;
    }

    @GetMapping(path = "/policies")
    public List<PolicyEntity> getPolicies() throws SQLException {
        return policyService.getAllPolicies();
    }

    @GetMapping(path = "/customers")
    public List<CustomerEntity> getCustomers() throws SQLException {
        return customerService.getCustomers();
    }
}
