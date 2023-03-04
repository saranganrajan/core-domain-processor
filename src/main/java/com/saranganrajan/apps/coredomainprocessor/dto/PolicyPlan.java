package com.saranganrajan.apps.coredomainprocessor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolicyPlan {
    private String planCode;
    private String planDescription;
    private boolean isHNW;
    private boolean isActive;
}
