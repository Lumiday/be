package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.PhotoFrameStyle;
import com.lumiday.springboot.core.domain.IntroLayoutDomain;

public record IntroLayOutResponse(
        String layoutType,
        PhotoFrameStyle photoFrameStyle,
        String imageName
) {
    public static IntroLayOutResponse of(IntroLayoutDomain introLayout) {
        return new IntroLayOutResponse(
                introLayout.getLayoutType(),
                introLayout.getPhotoFrameStyle(),
                introLayout.getImageName()
        );
    }
}
