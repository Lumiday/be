package com.lumiday.core.enums;

public enum DeceasedDisplayType {
    NONE("표시 안 함"),
    COLOR("색상 변경"),
    PREFIX_GOH("故 표시"),
    CHRYSANTHEMUM("국화 표시");
    
    private final String description;

    DeceasedDisplayType(String description) {
        this.description = description;
    }
}

