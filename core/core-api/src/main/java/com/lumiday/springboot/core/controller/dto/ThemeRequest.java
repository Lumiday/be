package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
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
