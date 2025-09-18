package com.lumiday.jpa.entity;

import com.lumiday.jpa.vo.AccountInfo;
import com.lumiday.jpa.vo.AttendanceCheck;
import com.lumiday.jpa.vo.BackgroundMusic;
import com.lumiday.jpa.vo.Ending;
import com.lumiday.jpa.vo.Gallery;
import com.lumiday.jpa.vo.IntroLayout;
import com.lumiday.jpa.vo.InvitationMessage;
import com.lumiday.jpa.vo.PersonBaseInfo;
import com.lumiday.jpa.vo.ThemeStyle;
import com.lumiday.jpa.vo.TransportationGuide;
import com.lumiday.jpa.vo.WeddingDate;
import com.lumiday.jpa.vo.WeddingPlace;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Embedded
    private IntroLayout introLayout;

    @Embedded
    private ThemeStyle theme;

    @Embedded
    private PersonBaseInfo personBaseInfo;

    @Embedded
    private WeddingDate weddingDate;

    @Embedded
    private WeddingPlace weddingPlace;

    @Embedded
    private InvitationMessage invitationMessage;

    @Embedded
    private BackgroundMusic backgroundMusic;

    @Embedded
    private TransportationGuide transportationGuide;

    @Embedded
    private AccountInfo accountInfo;

    @Embedded
    private Gallery gallery;

    @Embedded
    private AttendanceCheck attendanceCheck;

    @Embedded
    private Ending ending;

    private InvitationEntity(UserEntity user) {
        this.user = user;
    }

    @Builder
    public InvitationEntity(UserEntity user, IntroLayout introLayout, ThemeStyle theme, PersonBaseInfo personBaseInfo,
                            WeddingDate weddingDate, WeddingPlace weddingPlace, InvitationMessage invitationMessage,
                            BackgroundMusic backgroundMusic, TransportationGuide transportationGuide,
                            AccountInfo accountInfo, Gallery gallery, AttendanceCheck attendanceCheck, Ending ending) {

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
