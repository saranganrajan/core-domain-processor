package com.saranganrajan.apps.coredomainprocessor.external.database.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ahmf_policy")
public class PolicyEntity {

    @Id
    @Column(name = "pol_num")
    private String policyNumber;

    @Column(name = "plan_code")
    private String planCode;

    @Column(name = "pol_eff_dt")
    private LocalDate policyEffectiveDate;

    @Column(name = "pol_sbmt_dt")
    private LocalDate policySubmissionDate;

    @Column(name = "prem_paid")
    private double premiumPaid;

    @Column(name = "prem_due")
    private double premiumDue;

    @Column(name = "last_pmt_mode")
    private String lastPaymentMode;

    @Column(name = "pol_stat_cd")
    private String policyStatusCode;

    @Column(name = "agt_code")
    private String agentCode;

    @Column(name = "frez_code")
    private String freezeCode;

}
