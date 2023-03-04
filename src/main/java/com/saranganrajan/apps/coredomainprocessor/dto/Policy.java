package com.saranganrajan.apps.coredomainprocessor.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Policy {

    private String policyNumber;
    private String planCode;
    private String plan;
    private LocalDate policyEffectiveDate;
    private LocalDate policySubmissionDate;
    private double premiumPaid;
    private double premiumDue;
    private String lastPaymentMode;
    private String paymentMode;
    private String policyStatusCode;
    private String status;
    private String agentCode;
    private String agentName;
    private String freezeCode;
}
