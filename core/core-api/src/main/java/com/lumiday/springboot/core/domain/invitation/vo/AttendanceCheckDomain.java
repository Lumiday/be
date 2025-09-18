package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.AttendanceType;
import com.lumiday.springboot.core.controller.dto.AttendanceCheckRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AttendanceCheckDomain {
    private String title;
    private String content;
    private String buttonText;
    private AttendanceType type;

    public static AttendanceCheckDomain of(AttendanceCheckRequest request) {
        return new AttendanceCheckDomain(
                request.title(),
                request.content(),
                request.buttonText(),
                request.type()
        );
    }

    public static AttendanceCheckDomain of(String title, String content, String buttonText, AttendanceType type) {
        return new AttendanceCheckDomain(
                title, content, buttonText, type
        );
    }
}
