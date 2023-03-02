package com.saranganrajan.apps.coredomainprocessor.external.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ahmf_payment_history")
public class PaymentHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pmt_id")
    private Integer paymentId;

    @Column(name = "pol_num")
    private String policyNumber;

    @Column(name = "pmt_mode")
    private String paymentMode;

    @Column(name = "pmt_date")
    private LocalDate paymentDate;

    @Column(name = "pmt_amt")
    private Double paymentAmount;
}
