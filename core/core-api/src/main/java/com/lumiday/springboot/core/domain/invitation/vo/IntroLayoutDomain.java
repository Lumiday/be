package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.PhotoFrameStyle;
import lombok.Getter;

@Getter
public class IntroLayoutDomain {
    private String layoutType;
    private PhotoFrameStyle photoFrameStyle;
    private String imageName;

    public IntroLayoutDomain(String layoutType, PhotoFrameStyle photoFrameStyle, String imageName) {
        this.layoutType = layoutType;
        this.photoFrameStyle = photoFrameStyle;
        this.imageName = imageName;
    }
}
