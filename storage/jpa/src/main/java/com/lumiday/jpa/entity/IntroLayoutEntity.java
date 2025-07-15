package com.lumiday.jpa.entity;

import com.lumiday.core.enums.PhotoFrameStyle;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "intro_layouts")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class IntroLayoutEntity extends BaseEntity {
    private String layoutType;
    @Enumerated(EnumType.STRING)
    private PhotoFrameStyle photoFrameStyle;
    private String imageName;

    public static IntroLayoutEntity of(String layoutType,
                                       PhotoFrameStyle photoFrameStyle, String imageName) {
        return new IntroLayoutEntity(layoutType, photoFrameStyle, imageName);
    }

    public void update(String layoutType, PhotoFrameStyle photoFrameStyle, String imageName) {
        this.layoutType = layoutType;
        this.photoFrameStyle = photoFrameStyle;
        this.imageName = imageName;
    }
}
