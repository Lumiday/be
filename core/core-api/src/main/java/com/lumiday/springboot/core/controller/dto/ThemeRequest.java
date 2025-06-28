package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.theme.ThemeColor;
import com.lumiday.core.enums.theme.ThemeFontFamily;
import com.lumiday.core.enums.theme.ThemeFontSize;
import com.lumiday.core.enums.theme.ThemePattern;
import jakarta.validation.constraints.NotNull;

public record ThemeRequest(
        @NotNull ThemeFontFamily fontFamily,
        @NotNull ThemeFontSize fontSize,
        @NotNull ThemeColor backgroundColor,
        @NotNull ThemePattern backgroundPattern,
        @NotNull Boolean disableZoom,
        @NotNull Boolean enableScrollEffect
) {
}
