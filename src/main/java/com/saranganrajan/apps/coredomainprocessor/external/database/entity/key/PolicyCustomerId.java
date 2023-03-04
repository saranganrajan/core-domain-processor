package com.saranganrajan.apps.coredomainprocessor.external.database.entity.key;

import java.io.Serializable;

public class PolicyCustomerId implements Serializable {
    private String policyNumber;
    private String customerNumber;
    private String linkType;

    public PolicyCustomerId(String policyNumber, String customerNumber, String linkType) {
        this.policyNumber = policyNumber;
        this.customerNumber = customerNumber;
        this.linkType = linkType;
    }

    public PolicyCustomerId() {
    }
}
