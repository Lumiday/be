package com.lumiday.springboot.core.domain.invitation.vo;

import lombok.Getter;

@Getter
public class TransportationGuideDomain {

    private String transportationName;
    private String guideDescription;

    public TransportationGuideDomain(String transportationName, String guideDescription) {
        this.transportationName = transportationName;
        this.guideDescription = guideDescription;
    }
}
