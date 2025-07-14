package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.WeddingPlaceEntity;
import com.lumiday.springboot.core.domain.WeddingPlaceDomain;

public class WeddingPlaceEntityMapper {
    private WeddingPlaceEntityMapper() {
    }

    public static WeddingPlaceEntity toEntity(WeddingPlaceDomain domain) {
        return WeddingPlaceEntity.of(
                domain.getName(),
                domain.getDescription(),
                domain.getAddress(),
                domain.getShowMap(),
                domain.getPlaceMapType()
        );
    }

    public static WeddingPlaceDomain toDomain(WeddingPlaceEntity weddingDateEntity) {
        return WeddingPlaceDomain.of(
                weddingDateEntity.getName(),
                weddingDateEntity.getDescription(),
                weddingDateEntity.getAddress(),
                weddingDateEntity.getShowMap(),
                weddingDateEntity.getPlaceMapType()
        );
    }
}
