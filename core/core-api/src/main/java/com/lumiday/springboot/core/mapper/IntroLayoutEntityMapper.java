package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.IntroLayoutEntity;
import com.lumiday.springboot.core.domain.IntroLayoutDomain;

public class IntroLayoutEntityMapper {
    private IntroLayoutEntityMapper() {
    }

    public static IntroLayoutEntity toEntity(IntroLayoutDomain introLayoutDomain) {
        return IntroLayoutEntity.of(
                introLayoutDomain.getLayoutType(),
                introLayoutDomain.getPhotoFrameStyle()
        );
    }

    public static IntroLayoutDomain toDomain(IntroLayoutEntity introLayoutEntity) {
        return IntroLayoutDomain.of(
                introLayoutEntity.getLayoutType(),
                introLayoutEntity.getPhotoFrameStyle()
        );
    }
}
