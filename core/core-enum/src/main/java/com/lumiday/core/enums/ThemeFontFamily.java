package com.lumiday.core.enums;

public enum ThemeFontFamily {
    PRETENDARD("프리텐다드"),
    OWNGLYPH("온글잎"),
    GANGWON_EDU("강원교육모두체"),
    NANUM_MYEONGJO("나눔명조"),
    TMONEY_ROUND_WIND("티머니 둥근바람");

    private final String description;

    ThemeFontFamily(String description) {
        this.description = description;
    }
}
