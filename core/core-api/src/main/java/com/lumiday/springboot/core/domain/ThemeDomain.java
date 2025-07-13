package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import com.lumiday.springboot.core.controller.dto.ThemeRequest;
import lombok.Getter;

@Getter
public class ThemeDomain {
    private ThemeFontFamily fontFamily;
    private ThemeFontSize fontSize;
    private ThemeColor backgroundColor;
    private ThemePattern backgroundPattern;
    private Boolean disableZoom;
    private Boolean enableScrollEffect;

    private ThemeDomain(ThemeFontFamily fontFamily, ThemeFontSize fontSize, ThemeColor backgroundColor,
                        ThemePattern backgroundPattern, Boolean disableZoom, Boolean enableScrollEffect) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.backgroundColor = backgroundColor;
        this.backgroundPattern = backgroundPattern;
        this.disableZoom = disableZoom;
        this.enableScrollEffect = enableScrollEffect;
    }

    public static ThemeDomain of(ThemeFontFamily fontFamily, ThemeFontSize fontSize, ThemeColor backgroundColor,
                                 ThemePattern backgroundPattern, Boolean disableZoom, Boolean enableScrollEffect) {
        return new ThemeDomain(fontFamily, fontSize, backgroundColor, backgroundPattern, disableZoom,
                enableScrollEffect);
    }

    public static ThemeDomain of(ThemeRequest theme) {
        return new ThemeDomain(
                theme.fontFamily(),
                theme.fontSize(),
                theme.backgroundColor(),
                theme.backgroundPattern(),
                theme.disableZoom(),
                theme.enableScrollEffect()
        );
    }
}
