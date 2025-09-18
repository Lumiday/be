package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.AttendanceType;
import lombok.Getter;

@Getter
public class AttendanceCheckDomain {
    private String title;
    private String content;
    private String buttonText;
    private AttendanceType type;

    public AttendanceCheckDomain(String title, String content, String buttonText, AttendanceType type) {
        this.title = title;
        this.content = content;
        this.buttonText = buttonText;
        this.type = type;
    }
}
