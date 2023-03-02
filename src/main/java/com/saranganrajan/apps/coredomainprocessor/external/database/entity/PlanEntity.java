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
@Table(name = "ahmf_plan")
public class PlanEntity {

    @Id
    @Column(name = "plan_code")
    private String planCode;

    @Column(name = "plan_description")
    private String planDescription;

    @Column(name = "is_hnw")
    private boolean isHNW;

    @Column(name = "is_active")
    private boolean isActive;
}
