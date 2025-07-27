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
        return InvitationEntity.builder()
                .user(userEntity)
                .introLayout(IntroLayoutEntityMapper.toEntity(invitationDomain.getIntroLayout()))
                .theme(ThemeEntityMapper.toEntity(invitationDomain.getTheme()))
                .personBaseInfo(PersonBaseInfoEntityMapper.toEntity(invitationDomain.getPersonBaseInfo()))
                .weddingDate(WeddingDateEntityMapper.toEntity(invitationDomain.getWeddingDate()))
                .weddingPlace(WeddingPlaceEntityMapper.toEntity(invitationDomain.getWeddingPlace()))
                .invitationMessage(InvitationMessageEntityMapper.toEntity(invitationDomain.getInvitationMessage()))
                .build();
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
