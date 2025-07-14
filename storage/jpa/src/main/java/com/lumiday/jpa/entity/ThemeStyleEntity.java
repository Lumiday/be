package com.lumiday.jpa.entity;

import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "theme_styles")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThemeStyleEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ThemeFontFamily fontFamily;

    @Enumerated(EnumType.STRING)
    private ThemeFontSize fontSize;

    @Enumerated(EnumType.STRING)
    private ThemeColor backgroundColor;

    @Enumerated(EnumType.STRING)
    private ThemePattern backgroundPattern;

    private Boolean disableZoom;
    private Boolean enableScrollEffect;

    public static ThemeStyleEntity of(ThemeFontFamily fontFamily, ThemeFontSize fontSize,
                                      ThemeColor backgroundColor, ThemePattern backgroundPattern,
                                      Boolean disableZoom, Boolean enableScrollEffect) {
        return new ThemeStyleEntity(fontFamily, fontSize, backgroundColor, backgroundPattern,
                disableZoom, enableScrollEffect);
    }

}
