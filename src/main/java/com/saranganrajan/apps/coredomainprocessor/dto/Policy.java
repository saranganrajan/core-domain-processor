package com.saranganrajan.apps.coredomainprocessor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Policy {
    @JsonProperty("policyNumber")
    private String policyNumber;

    @JsonProperty("planCode")
    private String planCode;

    @JsonProperty("policyEffectiveDate")
    private LocalDate policyEffectiveDate;

    @JsonProperty("policySubmissionDate")
    private LocalDate policySubmissionDate;

    @JsonProperty("premiumPaid")
    private double premiumPaid;

    @JsonProperty("premiumDue")
    private double premiumDue;

    @JsonProperty("lastPaymentMode")
    private String lastPaymentMode;

    @JsonProperty("policyStatusCode")
    private String policyStatusCode;

    @JsonProperty("agentCode")
    private String agentCode;

    @JsonProperty("freezeCode")
    private String freezeCode;
}
