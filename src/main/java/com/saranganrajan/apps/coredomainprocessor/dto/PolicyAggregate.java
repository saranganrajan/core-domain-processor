package com.saranganrajan.apps.coredomainprocessor.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyAggregate {
    Policy policy;
    List<Customer> customers;
    List<CustomerPolicy> customerPolicies;
}
