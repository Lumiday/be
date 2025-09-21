package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;

public record ThemeResponse(
        ThemeFontFamily fontFamily,
        ThemeFontSize fontSize,
        ThemeColor backgroundColor,
        ThemePattern backgroundPattern,
        Boolean disableZoom,
        Boolean enableScrollEffect
) {
}
