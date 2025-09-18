package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import com.lumiday.springboot.core.domain.invitation.vo.ThemeDomain;

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
