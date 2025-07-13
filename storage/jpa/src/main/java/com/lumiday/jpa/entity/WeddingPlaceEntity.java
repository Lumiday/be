package com.lumiday.jpa.entity;

import com.lumiday.core.enums.PlaceMapType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "wedding_places")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WeddingPlaceEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private InvitationEntity invitation;

    private String name;
    private String description;
    private String address;
    private Boolean showMap;
    @Enumerated(EnumType.STRING)
    private PlaceMapType placeMapType;

    private WeddingPlaceEntity(InvitationEntity invitation, String name, String description,
                               String address, Boolean showMap, PlaceMapType placeMapType) {
        this.invitation = invitation;
        this.name = name;
        this.description = description;
        this.address = address;
        this.showMap = showMap;
        this.placeMapType = placeMapType;
    }

    public static WeddingPlaceEntity of(InvitationEntity invitation, String name, String description,
                                        String address, Boolean showMap, PlaceMapType placeMapType) {
        return new WeddingPlaceEntity(invitation, name, description, address, showMap, placeMapType);
    }
}
