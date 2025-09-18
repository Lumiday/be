package com.lumiday.jpa.vo;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ThemeStyle {

    @Column(name = "theme_font_family")
    @Enumerated(EnumType.STRING)
    private ThemeFontFamily fontFamily;

    @Column(name = "theme_font_size")
    @Enumerated(EnumType.STRING)
    private ThemeFontSize fontSize;

    @Column(name = "theme_color")
    @Enumerated(EnumType.STRING)
    private ThemeColor backgroundColor;

    @Column(name = "theme_pattern")
    @Enumerated(EnumType.STRING)
    private ThemePattern backgroundPattern;

    @Column(name = "theme_disable_zoom")
    private Boolean disableZoom;

    @Column(name = "theme_enable_scroll_effect")
    private Boolean enableScrollEffect;

    public static ThemeStyle of(
            ThemeFontFamily fontFamily,
            ThemeFontSize fontSize,
            ThemeColor backgroundColor,
            ThemePattern backgroundPattern,
            Boolean disableZoom,
            Boolean enableScrollEffect
    ) {
        if (fontFamily == null || fontSize == null || backgroundColor == null || backgroundPattern == null) {
            throw new IllegalArgumentException("fontFamily, fontSize, backgroundColor, backgroundPattern은 필수입니다.");
        }

        ThemeStyle style = new ThemeStyle();
        style.fontFamily = fontFamily;
        style.fontSize = fontSize;
        style.backgroundColor = backgroundColor;
        style.backgroundPattern = backgroundPattern;
        style.disableZoom = disableZoom == null ? Boolean.FALSE : disableZoom;
        style.enableScrollEffect = enableScrollEffect == null ? Boolean.FALSE : enableScrollEffect;
        return style;
    }
}
