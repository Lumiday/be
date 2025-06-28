package com.lumiday.jpa.entity;

import com.lumiday.core.enums.PhotoFrameStyle;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "intro_layouts")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IntroLayoutEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private InvitationEntity invitation;
    private String layoutType;
    @Enumerated(EnumType.STRING)
    private PhotoFrameStyle photoFrameStyle;

    private IntroLayoutEntity(InvitationEntity invitation, String layoutType, PhotoFrameStyle photoFrameStyle) {
        this.invitation = invitation;
        this.layoutType = layoutType;
        this.photoFrameStyle = photoFrameStyle;
    }

    public static IntroLayoutEntity of(InvitationEntity invitation, String layoutType,
                                       PhotoFrameStyle photoFrameStyle) {
        return new IntroLayoutEntity(invitation, layoutType, photoFrameStyle);
    }
}
