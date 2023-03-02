package com.saranganrajan.apps.coredomainprocessor.external.database.entity;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.key.PolicyCustomerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PolicyCustomerId.class)
@Table(name = "ahmf_policy_customer")
public class CustomerPolicyEntity {

    @Id
    @Column(name = "pol_num")
    private String policyNumber;

    @Id
    @Column(name = "customer_number")
    private String customerNumber;

    @Id
    @Column(name = "link_type")
    private String linkType;
}
