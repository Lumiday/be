package com.lumiday.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "invitations")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvitationEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "intro_layout_id")
    private IntroLayoutEntity introLayout;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theme_style_id")
    private ThemeStyleEntity theme;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_base_info_id")
    private PersonBaseInfoEntity personBaseInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "wedding_date_id")
    private WeddingDateEntity weddingDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "wedding_place_id")
    private WeddingPlaceEntity weddingPlace;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invitation_message_id")
    private InvitationMessageEntity invitationMessage;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "background_music_id")
    private BackgroundMusicEntity backgroundMusic;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transportation_guide_id")
    private TransportationGuideEntity transportationGuide;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_info_id")
    private AccountInfoEntity accountInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "gallery_id")
    private GalleryEntity gallery;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "attendance_check_id")
    private AttendanceCheckEntity attendanceCheck;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ending_id")
    private EndingEntity ending;

    private InvitationEntity(UserEntity user) {
        this.user = user;
    }

    @Builder
    public InvitationEntity(UserEntity user, IntroLayoutEntity introLayout, ThemeStyleEntity theme,
                            PersonBaseInfoEntity personBaseInfo, WeddingDateEntity weddingDate,
                            WeddingPlaceEntity weddingPlace, InvitationMessageEntity invitationMessage,
                            BackgroundMusicEntity backgroundMusic, TransportationGuideEntity transportationGuide,
                            AccountInfoEntity accountInfo, GalleryEntity gallery,
                            AttendanceCheckEntity attendanceCheck, EndingEntity ending) {

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

    public static InvitationEntity of(UserEntity user) {
        return new InvitationEntity(user);
    }
}
