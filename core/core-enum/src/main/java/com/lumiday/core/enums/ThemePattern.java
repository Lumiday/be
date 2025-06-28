package com.lumiday.core.enums;

public enum ThemePattern {
    NONE("없음"),
    PAPER("종이"),
    CHECK("체크"),
    SMALL_FLOWER("작은 꽃");

    private final String label;

    ThemePattern(String label) {
        this.label = label;
    }
}
