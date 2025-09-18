package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.invitation.vo.TransportationGuideDomain;

public record TransportationGuideResponse(
        String transportationName,
        String guideDescription
) {
    public static TransportationGuideResponse of(TransportationGuideDomain transportationGuide) {
        return new TransportationGuideResponse(
                transportationGuide.getTransportationName(),
                transportationGuide.getGuideDescription()
        );
    }
}
