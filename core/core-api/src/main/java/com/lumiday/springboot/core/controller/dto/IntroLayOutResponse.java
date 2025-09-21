package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.PhotoFrameStyle;

public record IntroLayOutResponse(
        String layoutType,
        PhotoFrameStyle photoFrameStyle,
        String imageName
) {
}
