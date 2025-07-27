package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.TransportationGuideEntity;
import com.lumiday.springboot.core.domain.TransportationGuideDomain;

public class TransportationGuideEntityMapper {

    private TransportationGuideEntityMapper() {
    }

    public static TransportationGuideEntity toEntity(TransportationGuideDomain domain) {
        return TransportationGuideEntity.of(
                domain.getTransportationName(),
                domain.getGuideDescription()
        );
    }

    public static TransportationGuideDomain toDomain(TransportationGuideEntity entity) {
        return TransportationGuideDomain.of(
                entity.getTransportationName(),
                entity.getGuideDescription()
        );
    }
}
