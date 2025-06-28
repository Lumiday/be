package com.lumiday.jpa.entity;

import com.lumiday.core.enums.theme.ThemeColor;
import com.lumiday.core.enums.theme.ThemeFontFamily;
import com.lumiday.core.enums.theme.ThemeFontSize;
import com.lumiday.core.enums.theme.ThemePattern;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "theme_styles")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ThemeStyleEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private InvitationEntity invitation;
    @Enumerated(EnumType.STRING)
    private ThemeFontFamily fontFamily;
    @Enumerated(EnumType.STRING)
    private ThemeFontSize fontSize;
    @Enumerated(EnumType.STRING)
    private ThemeColor backgroundColor;
    @Enumerated(EnumType.STRING)
    private ThemePattern backgroundPattern;
    private Boolean disableZoom;
    private Boolean enableScrollEffect;

    private ThemeStyleEntity(InvitationEntity invitation, ThemeFontFamily fontFamily, ThemeFontSize fontSize,
                             ThemeColor backgroundColor, ThemePattern backgroundPattern, Boolean disableZoom,
                             Boolean enableScrollEffect) {
        this.invitation = invitation;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.backgroundColor = backgroundColor;
        this.backgroundPattern = backgroundPattern;
        this.disableZoom = disableZoom;
        this.enableScrollEffect = enableScrollEffect;
    }

    public static ThemeStyleEntity of(InvitationEntity invitation, ThemeFontFamily fontFamily, ThemeFontSize fontSize,
                                      ThemeColor backgroundColor, ThemePattern backgroundPattern,
                                      Boolean disableZoom, Boolean enableScrollEffect) {
        return new ThemeStyleEntity(invitation, fontFamily, fontSize, backgroundColor, backgroundPattern,
                disableZoom, enableScrollEffect);
    }

}
