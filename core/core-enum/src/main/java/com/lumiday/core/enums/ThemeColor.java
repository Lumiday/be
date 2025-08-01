package com.lumiday.core.enums;

public enum ThemeColor {
    WHITE("#FFFFFF"),
    SKY_BLUE("#E0F1FF"),
    PINK_BEIGE("#ECDFE2"),
    IVORY("#F2ECE6"),
    LIGHT_CORAL("#FAD6D5");

    private final String description;

    ThemeColor(String description) {
        this.description = description;
    }
}
