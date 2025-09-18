package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.PlaceMapType;
import lombok.Getter;

@Getter
public class WeddingPlaceDomain {
    private String name;
    private String description;
    private String address;
    private Boolean showMap;
    private PlaceMapType placeMapType;

    public WeddingPlaceDomain(String name, String description, String address, Boolean showMap,
                              PlaceMapType placeMapType) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.showMap = showMap;
        this.placeMapType = placeMapType;
    }
}
