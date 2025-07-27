package com.lumiday.core.enums;

public enum GalleryType {
    SWIPE("스와이프"),
    GRID("그리드"),
    CHECKERBOARD("바둑판");

    private final String description;

    GalleryType(String description) {
        this.description = description;
    }
}
