package com.lumiday.jpa.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TransportationGuide {

    @Column(name = "transportation_name")
    private String transportationName;

    @Column(name = "transportation_guide_description")
    private String guideDescription;

    public static TransportationGuide of(String transportationName, String guideDescription) {
        if (transportationName == null || guideDescription == null) {
            throw new IllegalArgumentException("transportationName과 guideDescription은 필수입니다.");
        }
        TransportationGuide guide = new TransportationGuide();
        guide.transportationName = transportationName;
        guide.guideDescription = guideDescription;
        return guide;
    }
}