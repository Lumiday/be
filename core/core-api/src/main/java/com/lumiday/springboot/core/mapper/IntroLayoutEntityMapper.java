package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.IntroLayoutEntity;
import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.springboot.core.domain.IntroLayoutDomain;

public class IntroLayoutEntityMapper {
    private IntroLayoutEntityMapper() {
    }

    public static IntroLayoutEntity toEntity(InvitationEntity invitationEntity, IntroLayoutDomain introLayoutDomain) {
        return IntroLayoutEntity.of(
                invitationEntity,
                introLayoutDomain.getLayoutType(),
                introLayoutDomain.getPhotoFrameStyle()
        );
    }
}
