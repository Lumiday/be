package com.lumiday.core.enums;

public enum AttendanceType {
    HEADCOUNT("인원"),
    COMPANION_NAME("동행인 성함"),
    CONTACT("연락처"),
    MEAL("식사여부"),
    ETC("기타 전달사항");

    private final String description;

    AttendanceType(String description) {
        this.description = description;
    }
}
