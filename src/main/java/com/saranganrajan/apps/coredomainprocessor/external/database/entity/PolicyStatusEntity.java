package com.saranganrajan.apps.coredomainprocessor.external.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ahmf_policy_status")
public class PolicyStatusEntity {

    @Id
    @Column(name = "pol_stat_cd")
    private String policyStatusCode;

    @Column(name = "description")
    private String description;

}
