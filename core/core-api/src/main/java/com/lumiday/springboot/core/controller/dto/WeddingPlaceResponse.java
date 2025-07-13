package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.PlaceMapType;
import com.lumiday.springboot.core.domain.WeddingPlaceDomain;

public record WeddingPlaceResponse(
        String name,
        String description,
        String address,
        Boolean showMap,
        PlaceMapType placeMapType
) {
    public static WeddingPlaceResponse of(WeddingPlaceDomain weddingPlaceDomain) {
        return new WeddingPlaceResponse(
                weddingPlaceDomain.getName(),
                weddingPlaceDomain.getDescription(),
                weddingPlaceDomain.getAddress(),
                weddingPlaceDomain.getShowMap(),
                weddingPlaceDomain.getPlaceMapType()
        );
    }
}
