package com.saranganrajan.apps.coredomainprocessor.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PaymentHistory {
    private Integer paymentId;
    private String policyNumber;
    private String paymentMode;
    private LocalDate paymentDate;
    private Double paymentAmount;
}
