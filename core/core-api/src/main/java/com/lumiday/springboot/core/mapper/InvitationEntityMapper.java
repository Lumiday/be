package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.springboot.core.domain.InvitationDomain;

public class InvitationEntityMapper {
    private InvitationEntityMapper() {
    }

    public static InvitationEntity toEntity(UserEntity userEntity) {
        return InvitationEntity.of(userEntity);
    }

    public static InvitationEntity toEntity(UserEntity userEntity, InvitationDomain invitationDomain) {
        return InvitationEntity.of(
                userEntity,
                IntroLayoutEntityMapper.toEntity(invitationDomain.getIntroLayout()),
                ThemeEntityMapper.toEntity(invitationDomain.getTheme()),
                PersonBaseInfoEntityMapper.toEntity(invitationDomain.getPersonBaseInfo()),
                WeddingDateEntityMapper.toEntity(invitationDomain.getWeddingDate()),
                WeddingPlaceEntityMapper.toEntity(invitationDomain.getWeddingPlace()),
                InvitationMessageEntityMapper.toEntity(invitationDomain.getInvitationMessage())
        );
    }

    public static InvitationDomain toDomain(InvitationEntity invitationEntity) {
        return InvitationDomain.of(UserEntityMapper.toDomain(invitationEntity.getUser()),
                IntroLayoutEntityMapper.toDomain(invitationEntity.getIntroLayout()),
                ThemeEntityMapper.toDomain(invitationEntity.getTheme()),
                PersonBaseInfoEntityMapper.toDomain(invitationEntity.getPersonBaseInfo()),
                WeddingDateEntityMapper.toDomain(invitationEntity.getWeddingDate()),
                WeddingPlaceEntityMapper.toDomain(invitationEntity.getWeddingPlace()),
                InvitationMessageEntityMapper.toDomain(invitationEntity.getInvitationMessage()));
    }
}
