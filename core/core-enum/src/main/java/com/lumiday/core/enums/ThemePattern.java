package com.lumiday.core.enums;

public enum ThemePattern {
    NONE("없음"),
    PAPER("종이"),
    CHECK("체크"),
    SMALL_FLOWER("작은 꽃");

    private final String description;

    ThemePattern(String description) {
        this.description = description;
    }
}
