package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.PlaceMapType;
import com.lumiday.springboot.core.controller.dto.WeddingPlaceRequest;
import lombok.Getter;

@Getter
public class WeddingPlaceDomain {
    private String name;
    private String description;
    private String address;
    private Boolean showMap;
    private PlaceMapType placeMapType;

    private WeddingPlaceDomain(String name, String description, String address, Boolean showMap,
                               PlaceMapType placeMapType) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.showMap = showMap;
        this.placeMapType = placeMapType;
    }

    public static WeddingPlaceDomain of(String name, String description, String address, Boolean showMap,
                                        PlaceMapType placeMapType) {
        return new WeddingPlaceDomain(name, description, address, showMap, placeMapType);
    }

    public static WeddingPlaceDomain of(WeddingPlaceRequest request) {
        return new WeddingPlaceDomain(
                request.name(),
                request.description(),
                request.address(),
                request.showMap(),
                request.placeMapType()
        );
    }
}
