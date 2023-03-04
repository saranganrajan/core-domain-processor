package com.saranganrajan.apps.coredomainprocessor.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class PolicyAggregate {
    Policy policy;
    List<Customer> customers;
    List<CustomerPolicy> customerPolicies;
}
