package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "wedding_places")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WeddingPlaceEntity extends BaseEntity {
    private String name;
    private String description;
    private String address;
    private Boolean showMap;
    private String mapType;
}
