package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.TransportationGuide;
import com.lumiday.springboot.core.domain.invitation.vo.TransportationGuideDomain;

public class TransportationGuideEntityMapper {

    private TransportationGuideEntityMapper() {
    }

    public static TransportationGuide toEntity(TransportationGuideDomain domain) {
        return TransportationGuide.of(
                domain.getTransportationName(),
                domain.getGuideDescription()
        );
    }

    public static TransportationGuideDomain toDomain(TransportationGuide entity) {
        return TransportationGuideDomain.of(
                entity.getTransportationName(),
                entity.getGuideDescription()
        );
    }
}
