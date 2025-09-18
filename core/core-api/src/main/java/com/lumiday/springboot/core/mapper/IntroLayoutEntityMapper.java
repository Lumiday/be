package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.IntroLayout;
import com.lumiday.springboot.core.domain.invitation.vo.IntroLayoutDomain;

public class IntroLayoutEntityMapper {
    private IntroLayoutEntityMapper() {
    }

    public static IntroLayout toEntity(IntroLayoutDomain introLayoutDomain) {
        return IntroLayout.of(
                introLayoutDomain.getLayoutType(),
                introLayoutDomain.getPhotoFrameStyle(),
                introLayoutDomain.getImageName()
        );
    }

    public static IntroLayoutDomain toDomain(IntroLayout introLayout) {
        return IntroLayoutDomain.of(
                introLayout.getLayoutType(),
                introLayout.getPhotoFrameStyle(),
                introLayout.getImageName()
        );
    }
}
