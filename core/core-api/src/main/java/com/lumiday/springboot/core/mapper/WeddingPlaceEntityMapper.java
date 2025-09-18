package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.WeddingPlace;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingPlaceDomain;

public class WeddingPlaceEntityMapper {
    private WeddingPlaceEntityMapper() {
    }

    public static WeddingPlace toEntity(WeddingPlaceDomain domain) {
        return WeddingPlace.of(
                domain.getName(),
                domain.getDescription(),
                domain.getAddress(),
                domain.getShowMap(),
                domain.getPlaceMapType()
        );
    }

    public static WeddingPlaceDomain toDomain(WeddingPlace weddingDateEntity) {
        return WeddingPlaceDomain.of(
                weddingDateEntity.getName(),
                weddingDateEntity.getDescription(),
                weddingDateEntity.getAddress(),
                weddingDateEntity.getShowMap(),
                weddingDateEntity.getPlaceMapType()
        );
    }
}
