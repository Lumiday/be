package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import com.lumiday.springboot.core.controller.dto.ThemeRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeDomain {
    private ThemeFontFamily fontFamily;
    private ThemeFontSize fontSize;
    private ThemeColor backgroundColor;
    private ThemePattern backgroundPattern;
    private Boolean disableZoom;
    private Boolean enableScrollEffect;

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
