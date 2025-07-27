package com.lumiday.core.enums;

public enum AccountDesignType {
    BASIC("기본"),
    BUTTON("버튼"),
    ACCORDION("아코디언");

    private final String description;

    AccountDesignType(String description) {
        this.description = description;
    }
}
