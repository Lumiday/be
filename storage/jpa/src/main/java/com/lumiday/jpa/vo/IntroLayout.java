package com.lumiday.jpa.vo;

import com.lumiday.core.enums.PhotoFrameStyle;
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
public class IntroLayout {

    @Column(name = "intro_layout_type")
    private String layoutType;

    @Column(name = "intro_photo_frame_style")
    @Enumerated(EnumType.STRING)
    private PhotoFrameStyle photoFrameStyle;

    @Column(name = "intro_image_name")
    private String imageName;

    public IntroLayout(String layoutType, PhotoFrameStyle photoFrameStyle, String imageName) {
        if (layoutType == null || photoFrameStyle == null) {
            throw new IllegalArgumentException("layoutType과 photoFrameStyle은 필수입니다.");
        }
        this.layoutType = layoutType;
        this.photoFrameStyle = photoFrameStyle;
        this.imageName = imageName;
    }
}