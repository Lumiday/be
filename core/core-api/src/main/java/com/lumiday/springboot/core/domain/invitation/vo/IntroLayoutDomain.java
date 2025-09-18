package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.PhotoFrameStyle;
import com.lumiday.springboot.core.controller.dto.IntroLayoutRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class IntroLayoutDomain {
    private String layoutType;
    private PhotoFrameStyle photoFrameStyle;
    private String imageName;

    public static IntroLayoutDomain of(String layoutType, PhotoFrameStyle photoFrameStyle, String imageName) {
        return new IntroLayoutDomain(layoutType, photoFrameStyle, imageName);
    }

    public static IntroLayoutDomain of(IntroLayoutRequest introLayoutRequest) {
        return new IntroLayoutDomain(
                introLayoutRequest.layoutType(),
                introLayoutRequest.photoFrameStyle(),
                introLayoutRequest.imageName()
        );
    }
}
