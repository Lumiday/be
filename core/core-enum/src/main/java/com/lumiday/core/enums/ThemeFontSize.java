package com.lumiday.core.enums;

public enum ThemeFontSize {
    NORMAL("보통"),
    LARGER("더 크게"),
    SMALLER("더 작게");

    private final String label;

    ThemeFontSize(String label) {
        this.label = label;
    }
}
