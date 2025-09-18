package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.springboot.core.controller.dto.TransportationGuideRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransportationGuideDomain {

    private String transportationName;
    private String guideDescription;

    public static TransportationGuideDomain of(TransportationGuideRequest request) {
        return new TransportationGuideDomain(
                request.transportationName(),
                request.guideDescription()
        );
    }

    public static TransportationGuideDomain of(String transportationName, String guideDescription) {
        return new TransportationGuideDomain(
                transportationName,
                guideDescription
        );
    }
}
