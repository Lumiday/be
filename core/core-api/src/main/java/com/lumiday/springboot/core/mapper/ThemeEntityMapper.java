package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.ThemeStyleEntity;
import com.lumiday.springboot.core.domain.ThemeDomain;

public class ThemeEntityMapper {
    private ThemeEntityMapper() {
    }

    public static ThemeStyleEntity toEntity(ThemeDomain domain) {
        return ThemeStyleEntity.of(
                domain.getFontFamily(),
                domain.getFontSize(),
                domain.getBackgroundColor(),
                domain.getBackgroundPattern(),
                domain.getDisableZoom(),
                domain.getEnableScrollEffect()
        );
    }

    public static ThemeDomain toDomain(ThemeStyleEntity themeEntity) {
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
