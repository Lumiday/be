package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "transportation_guides")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransportationGuideEntity extends BaseEntity {

    private String transportationName;
    private String guideDescription;

    public static TransportationGuideEntity of(String transportationName, String guideDescription) {
        return new TransportationGuideEntity(transportationName, guideDescription);
    }
}
