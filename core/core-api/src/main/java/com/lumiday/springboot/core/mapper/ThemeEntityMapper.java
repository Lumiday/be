package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.ThemeStyle;
import com.lumiday.springboot.core.domain.invitation.vo.ThemeDomain;

public class ThemeEntityMapper {
    private ThemeEntityMapper() {
    }

    public static ThemeStyle toEntity(ThemeDomain domain) {
        return ThemeStyle.of(
                domain.getFontFamily(),
                domain.getFontSize(),
                domain.getBackgroundColor(),
                domain.getBackgroundPattern(),
                domain.getDisableZoom(),
                domain.getEnableScrollEffect()
        );
    }

    public static ThemeDomain toDomain(ThemeStyle themeEntity) {
        return ThemeDomain.of(
                themeEntity.getFontFamily(),
                themeEntity.getFontSize(),
                themeEntity.getBackgroundColor(),
                themeEntity.getBackgroundPattern(),
                themeEntity.getDisableZoom(),
                themeEntity.getEnableScrollEffect()
        );
    }
}
