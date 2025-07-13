package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.springboot.core.domain.InvitationDomain;

public class InvitationEntityMapper {
    private InvitationEntityMapper() {
    }

    public static InvitationEntity toEntity(UserEntity userEntity, InvitationDomain invitationDomain) {
        return InvitationEntity.of(userEntity, invitationDomain.getDeceasedDisplayType());
    }

    public static InvitationDomain toDomain(InvitationEntity invitationEntity) {
        return InvitationDomain.of(UserEntityMapper.toDomain(invitationEntity.getUser()),
                IntroLayoutEntityMapper.toDomain(invitationEntity.getIntroLayout()),
                ThemeEntityMapper.toDomain(invitationEntity.getTheme()),
                invitationEntity.getPersonInfoList().stream().map(PersonInfoEntityMapper::toDomain).toList(),
                invitationEntity.getDeceasedDisplayType(),
                WeddingDateEntityMapper.toDomain(invitationEntity.getWeddingDate()));
    }
}
