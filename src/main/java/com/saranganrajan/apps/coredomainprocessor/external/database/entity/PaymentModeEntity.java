package com.saranganrajan.apps.coredomainprocessor.external.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ahmf_payment_mode")
public class PaymentModeEntity {

    @Id
    @Column(name = "pmt_mode")
    private String paymentMode;

    @Column(name = "description")
    private String description;

}
