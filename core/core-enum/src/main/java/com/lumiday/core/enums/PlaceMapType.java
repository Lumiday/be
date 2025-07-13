package com.lumiday.core.enums;

public enum PlaceMapType {
    NAVER("네이버지도"),
    KAKAO("카카오 맵"),
    GOOGLE("구글 맵");

    private final String description;

    PlaceMapType(String description) {
        this.description = description;
    }
}
