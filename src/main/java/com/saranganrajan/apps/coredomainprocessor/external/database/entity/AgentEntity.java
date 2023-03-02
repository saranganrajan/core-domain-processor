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
@Table(name = "ahmf_agent")
public class AgentEntity {

    @Id
    @Column(name = "agt_code")
    private String agentCode;

    @Column(name = "agent_name")
    private String agentName;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "is_active")
    private String isActive;

}
