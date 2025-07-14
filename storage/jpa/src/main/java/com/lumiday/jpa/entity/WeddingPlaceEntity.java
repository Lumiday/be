package com.lumiday.jpa.entity;

import com.lumiday.core.enums.PlaceMapType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "wedding_places")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WeddingPlaceEntity extends BaseEntity {

    private String name;
    private String description;
    private String address;
    private Boolean showMap;
    @Enumerated(EnumType.STRING)
    private PlaceMapType placeMapType;

    public static WeddingPlaceEntity of(String name, String description,
                                        String address, Boolean showMap, PlaceMapType placeMapType) {
        return new WeddingPlaceEntity(name, description, address, showMap, placeMapType);
    }
}
