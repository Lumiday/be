package com.lumiday.springboot.core.controller.dto;

public record TransportationGuideRequest(
        String transportationName,
        String guideDescription
) {
}
