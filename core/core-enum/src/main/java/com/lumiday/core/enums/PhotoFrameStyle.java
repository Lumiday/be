package com.lumiday.core.enums;

public enum PhotoFrameStyle {
    BASIC("기본"),
    ARCH("아치"),
    ROUNDED("둥근 모서리"),
    FRAME("액자");

    private final String description;

    PhotoFrameStyle(String description) {
        this.description = description;
    }
}
