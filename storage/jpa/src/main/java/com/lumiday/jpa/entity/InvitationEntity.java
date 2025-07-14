package com.lumiday.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "invitations")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    private InvitationEntity(UserEntity user) {
        this.user = user;
    }

    public static InvitationEntity of(UserEntity user) {
        return new InvitationEntity(user);
    }

    public static InvitationEntity of(UserEntity user, IntroLayoutEntity introLayout,
                                      ThemeStyleEntity theme, PersonBaseInfoEntity personBaseInfo,
                                      WeddingDateEntity weddingDate, WeddingPlaceEntity weddingPlace,
                                      InvitationMessageEntity invitationMessage) {
        return new InvitationEntity(
                user,
                introLayout,
                theme,
                personBaseInfo,
                weddingDate,
                weddingPlace,
                invitationMessage
        );
    }
}
