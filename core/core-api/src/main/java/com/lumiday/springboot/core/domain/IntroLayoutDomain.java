package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.PhotoFrameStyle;
import com.lumiday.springboot.core.controller.dto.IntroLayoutRequest;
import lombok.Getter;

@Getter
public class IntroLayoutDomain {
    String layoutType;
    PhotoFrameStyle photoFrameStyle;

    private IntroLayoutDomain(String layoutType, PhotoFrameStyle photoFrameStyle) {
        this.layoutType = layoutType;
        this.photoFrameStyle = photoFrameStyle;
    }

    public static IntroLayoutDomain of(String layoutType, PhotoFrameStyle photoFrameStyle) {
        return new IntroLayoutDomain(layoutType, photoFrameStyle);
    }

    public static IntroLayoutDomain of(IntroLayoutRequest introLayoutRequest) {
        return new IntroLayoutDomain(
                introLayoutRequest.layoutType(),
                introLayoutRequest.photoFrameStyle()
        );
    }
}
