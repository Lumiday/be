package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.WeddingPlace;
import com.lumiday.springboot.core.controller.dto.WeddingPlaceRequest;
import com.lumiday.springboot.core.controller.dto.WeddingPlaceResponse;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingPlaceDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeddingPlaceMapper {
    WeddingPlaceMapper INSTANCE = Mappers.getMapper(WeddingPlaceMapper.class);

    WeddingPlace toEntity(WeddingPlaceDomain domain);

    WeddingPlaceDomain toDomain(WeddingPlace weddingDateEntity);

    WeddingPlaceDomain toDomain(WeddingPlaceRequest weddingDateEntity);

    WeddingPlaceResponse toResponse(WeddingPlaceDomain weddingPlaceDomain);
}
