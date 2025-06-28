package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.theme.ThemeColor;
import com.lumiday.core.enums.theme.ThemeFontFamily;
import com.lumiday.core.enums.theme.ThemeFontSize;
import com.lumiday.core.enums.theme.ThemePattern;
import com.lumiday.springboot.core.domain.ThemeDomain;

public record ThemeResponse(
        ThemeFontFamily fontFamily,
        ThemeFontSize fontSize,
        ThemeColor backgroundColor,
        ThemePattern backgroundPattern,
        Boolean disableZoom,
        Boolean enableScrollEffect
) {
    public static ThemeResponse of(ThemeDomain theme) {
        return new ThemeResponse(
                theme.getFontFamily(),
                theme.getFontSize(),
                theme.getBackgroundColor(),
                theme.getBackgroundPattern(),
                theme.getDisableZoom(),
                theme.getEnableScrollEffect()
        );
    }
}
