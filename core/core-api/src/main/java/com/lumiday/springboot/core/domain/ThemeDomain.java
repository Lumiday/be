package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.theme.ThemeColor;
import com.lumiday.core.enums.theme.ThemeFontFamily;
import com.lumiday.core.enums.theme.ThemeFontSize;
import com.lumiday.core.enums.theme.ThemePattern;
import com.lumiday.springboot.core.controller.dto.ThemeRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ThemeDomain {
    private final ThemeFontFamily fontFamily;
    private final ThemeFontSize fontSize;
    private final ThemeColor backgroundColor;
    private final ThemePattern backgroundPattern;
    private final Boolean disableZoom;
    private final Boolean enableScrollEffect;

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

    public static ThemeDomain of(@NotNull ThemeRequest theme) {
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
