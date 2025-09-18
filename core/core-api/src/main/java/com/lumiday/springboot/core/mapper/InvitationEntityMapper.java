package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.springboot.core.domain.invitation.aggregate.InvitationDomain;

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
        return InvitationDomain.builder()
                .user(UserEntityMapper.toDomain(invitationEntity.getUser()))
                .introLayout(IntroLayoutEntityMapper.toDomain(invitationEntity.getIntroLayout()))
                .theme(ThemeEntityMapper.toDomain(invitationEntity.getTheme()))
                .personBaseInfo(PersonBaseInfoEntityMapper.toDomain(invitationEntity.getPersonBaseInfo()))
                .weddingDate(WeddingDateEntityMapper.toDomain(invitationEntity.getWeddingDate()))
                .weddingPlace(WeddingPlaceEntityMapper.toDomain(invitationEntity.getWeddingPlace()))
                .invitationMessage(InvitationMessageEntityMapper.toDomain(invitationEntity.getInvitationMessage()))
                .backgroundMusic(BackgroundMusicEntityMapper.toDomain(invitationEntity.getBackgroundMusic()))
                .transportationGuide(
                        TransportationGuideEntityMapper.toDomain(invitationEntity.getTransportationGuide()))
                .accountInfo(AccountInfoEntityMapper.toDomain(invitationEntity.getAccountInfo()))
                .gallery(GalleryEntityMapper.toDomain(invitationEntity.getGallery()))
                .attendanceCheck(AttendanceCheckEntityMapper.toDomain(invitationEntity.getAttendanceCheck()))
                .ending(EndingEntityMapper.toDomain(invitationEntity.getEnding()))
                .build();
    }
}
