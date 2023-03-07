package com.saranganrajan.apps.coredomainprocessor.external.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ahmf_policy_transaction")
public class PolicyTransactionEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "transaction_id")
    private String policyTransactionId;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "premium_paid")
    private Double premiumPaid;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "status")
    private String status;

}
