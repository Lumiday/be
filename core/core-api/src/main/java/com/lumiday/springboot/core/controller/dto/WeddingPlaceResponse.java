package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.PlaceMapType;

public record WeddingPlaceResponse(
        String name,
        String description,
        String address,
        Boolean showMap,
        PlaceMapType placeMapType
) {

}
