package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.TransportationGuide;
import com.lumiday.springboot.core.controller.dto.TransportationGuideRequest;
import com.lumiday.springboot.core.controller.dto.TransportationGuideResponse;
import com.lumiday.springboot.core.domain.invitation.vo.TransportationGuideDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransportationGuideMapper {

    TransportationGuideMapper INSTANCE = Mappers.getMapper(TransportationGuideMapper.class);

    TransportationGuide toEntity(TransportationGuideDomain domain);

    TransportationGuideDomain toDomain(TransportationGuide entity);

    TransportationGuideDomain toDomain(TransportationGuideRequest entity);

    TransportationGuideResponse toResponse(TransportationGuideDomain domain);
}
