package com.lumiday.core.enums;

public enum PersonRole {
    GROOM("신랑"),
    BRIDE("신부"),
    GROOM_FATHER("신랑 아버지"),
    GROOM_MOTHER("신랑 어머니"),
    BRIDE_FATHER("신부 아버지"),
    BRIDE_MOTHER("신부 어머니");

    private final String description;

    PersonRole(String description) {
        this.description = description;
    }
}
