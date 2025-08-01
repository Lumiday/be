package com.lumiday.springboot.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class InvitationDomain {
    private UserDomain user;
    private IntroLayoutDomain introLayout;
    private ThemeDomain theme;
    private PersonBaseInfoDomain personBaseInfo;
    private WeddingDateDomain weddingDate;
    private WeddingPlaceDomain weddingPlace;
    private InvitationMessageDomain invitationMessage;
    private BackgroundMusicDomain backgroundMusic;
    private TransportationGuideDomain transportationGuide;
    private AccountInfoDomain accountInfo;
    private GalleryDomain gallery;
    private AttendanceCheckDomain attendanceCheck;
    private EndingDomain ending;

    @Builder
    public InvitationDomain(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme,
                            PersonBaseInfoDomain personBaseInfo, WeddingDateDomain weddingDate,
                            WeddingPlaceDomain weddingPlace, InvitationMessageDomain invitationMessage,
                            BackgroundMusicDomain backgroundMusic, TransportationGuideDomain transportationGuide,
                            AccountInfoDomain accountInfo, GalleryDomain gallery,
                            AttendanceCheckDomain attendanceCheck, EndingDomain ending) {
        if (user == null || introLayout == null || theme == null || personBaseInfo == null || weddingDate == null
                || weddingPlace == null || invitationMessage == null) {
            throw new IllegalArgumentException(
                    "모든 필수 필드는 null이 될 수 없습니다. user, introLayout, theme, personBaseInfo, weddingDate, weddingPlace, invitationMessage는 필수입니다.");
        }
        this.user = user;
        this.introLayout = introLayout;
        this.theme = theme;
        this.personBaseInfo = personBaseInfo;
        this.weddingDate = weddingDate;
        this.weddingPlace = weddingPlace;
        this.invitationMessage = invitationMessage;
        this.backgroundMusic = backgroundMusic;
        this.transportationGuide = transportationGuide;
        this.accountInfo = accountInfo;
        this.gallery = gallery;
        this.attendanceCheck = attendanceCheck;
        this.ending = ending;
    }
}
