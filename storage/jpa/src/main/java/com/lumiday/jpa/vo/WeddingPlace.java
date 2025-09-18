package com.lumiday.jpa.vo;

import com.lumiday.core.enums.PlaceMapType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WeddingPlace {

    @Column(name = "wedding_place_name")
    private String name;

    @Column(name = "wedding_place_description")
    private String description;

    @Column(name = "wedding_place_address")
    private String address;

    @Column(name = "wedding_place_show_map")
    private Boolean showMap;

    @Column(name = "wedding_place_map_type")
    @Enumerated(EnumType.STRING)
    private PlaceMapType placeMapType;

    public static WeddingPlace of(String name, String description, String address, Boolean showMap,
                                  PlaceMapType placeMapType) {
        if (name == null || address == null) {
            throw new IllegalArgumentException("name과 address는 필수입니다.");
        }
        WeddingPlace place = new WeddingPlace();
        place.name = name;
        place.description = description;
        place.address = address;
        place.showMap = (showMap != null) ? showMap : Boolean.TRUE;
        place.placeMapType = placeMapType; // null 허용
        return place;
    }
}