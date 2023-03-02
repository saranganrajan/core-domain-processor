package com.saranganrajan.apps.coredomainprocessor.controller;

import com.saranganrajan.apps.coredomainprocessor.dto.PolicyTransaction;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.service.customer.CustomerService;
import com.saranganrajan.apps.coredomainprocessor.service.manager.ManagerService;
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

    @Autowired
    ManagerService managerService;

    public CommonController(PolicyService policyService, CustomerService customerService, ManagerService managerService) {
        this.policyService = policyService;
        this.customerService = customerService;
        this.managerService = managerService;
    }

    @PostMapping(path = "/policy/premium/pay", consumes = "application/json")
    public void processPolicy(@RequestBody List<PolicyTransaction> policies) {
        managerService.processTransactions(policies);
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
