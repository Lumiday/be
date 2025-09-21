package com.lumiday.jpa.entity;

import com.lumiday.jpa.vo.AccountInfo;
import com.lumiday.jpa.vo.AttendanceCheck;
import com.lumiday.jpa.vo.BackgroundMusic;
import com.lumiday.jpa.vo.Ending;
import com.lumiday.jpa.vo.Gallery;
import com.lumiday.jpa.vo.IntroLayout;
import com.lumiday.jpa.vo.InvitationMessage;
import com.lumiday.jpa.vo.PersonBasicInfo;
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
    private PersonBasicInfo personBasicInfo;

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
    public InvitationEntity(UserEntity user, IntroLayout introLayout, ThemeStyle theme, PersonBasicInfo personBasicInfo,
                            WeddingDate weddingDate, WeddingPlace weddingPlace, InvitationMessage invitationMessage,
                            BackgroundMusic backgroundMusic, TransportationGuide transportationGuide,
                            AccountInfo accountInfo, Gallery gallery, AttendanceCheck attendanceCheck, Ending ending) {

        if (user == null || introLayout == null || theme == null || personBasicInfo == null || weddingDate == null
                || weddingPlace == null || invitationMessage == null) {
            throw new IllegalArgumentException(
                    "모든 필수 필드는 null이 될 수 없습니다. user, introLayout, theme, personBaseInfo, weddingDate, weddingPlace, invitationMessage는 필수입니다.");
        }

        this.user = user;
        this.introLayout = introLayout;
        this.theme = theme;
        this.personBasicInfo = personBasicInfo;
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

    public void changeIntroLayout(IntroLayout introLayout) {
        if (introLayout == null) {
            throw new IllegalArgumentException("introLayout은 null이 될 수 없습니다.");
        }
        this.introLayout = introLayout;
    }

    public void changeInvitationMessage(InvitationMessage invitationMessage) {
        if (invitationMessage == null) {
            throw new IllegalArgumentException("invitationMessage는 null이 될 수 없습니다.");
        }
        this.invitationMessage = invitationMessage;
    }

    public void changePersonBaseInfo(PersonBasicInfo personBasicInfo) {
        if (personBasicInfo == null) {
            throw new IllegalArgumentException("personBaseInfo는 null이 될 수 없습니다.");
        }
        this.personBasicInfo = personBasicInfo;
    }

    public void changeTheme(ThemeStyle themeStyle) {
        if (themeStyle == null) {
            throw new IllegalArgumentException("theme는 null이 될 수 없습니다.");
        }
        this.theme = themeStyle;
    }

    public void changeWeddingDate(WeddingDate weddingDate) {
        if (weddingDate == null) {
            throw new IllegalArgumentException("weddingDate는 null이 될 수 없습니다.");
        }
        this.weddingDate = weddingDate;
    }

    public void changeWeddingPlace(WeddingPlace weddingPlace) {
        if (weddingPlace == null) {
            throw new IllegalArgumentException("weddingPlace는 null이 될 수 없습니다.");
        }
        this.weddingPlace = weddingPlace;
    }

    public void changeAccountInfo(AccountInfo accountInfo) {
        if (accountInfo == null) {
            throw new IllegalArgumentException("accountInfo는 null이 될 수 없습니다.");
        }
    }

    public void changeAttendanceCheck(AttendanceCheck attendanceCheck) {
        if (attendanceCheck == null) {
            throw new IllegalArgumentException("attendanceCheck는 null이 될 수 없습니다.");
        }
        this.attendanceCheck = attendanceCheck;
    }

    public void changeBackgroundMusic(BackgroundMusic backgroundMusic) {
        if (backgroundMusic == null) {
            throw new IllegalArgumentException("backgroundMusic는 null이 될 수 없습니다.");
        }
        this.backgroundMusic = backgroundMusic;
    }

    public void changeEnding(Ending ending) {
        if (ending == null) {
            throw new IllegalArgumentException("ending는 null이 될 수 없습니다.");
        }
        this.ending = ending;
    }

    public void changeGallery(Gallery gallery) {
        if (gallery == null) {
            throw new IllegalArgumentException("gallery는 null이 될 수 없습니다.");
        }
        this.gallery = gallery;
    }

    public void changeTransportationGuide(TransportationGuide transportationGuide) {
        if (transportationGuide == null) {
            throw new IllegalArgumentException("transportationGuide는 null이 될 수 없습니다.");
        }
        this.transportationGuide = transportationGuide;
    }
}
