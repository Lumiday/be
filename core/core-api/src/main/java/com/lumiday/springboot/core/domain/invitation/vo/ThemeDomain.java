package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import lombok.Getter;

@Getter
public class ThemeDomain {
    private ThemeFontFamily fontFamily;
    private ThemeFontSize fontSize;
    private ThemeColor backgroundColor;
    private ThemePattern backgroundPattern;
    private Boolean disableZoom;
    private Boolean enableScrollEffect;

    public ThemeDomain(ThemeFontFamily fontFamily, ThemeFontSize fontSize, ThemeColor backgroundColor,
                       ThemePattern backgroundPattern, Boolean disableZoom, Boolean enableScrollEffect) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.backgroundColor = backgroundColor;
        this.backgroundPattern = backgroundPattern;
        this.disableZoom = disableZoom;
        this.enableScrollEffect = enableScrollEffect;
    }
}
