package com.saranganrajan.apps.coredomainprocessor.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class Agent {
    private String agentCode;
    private String agentName;
    private LocalDate dateOfBirth;
    private String isActive;

}
