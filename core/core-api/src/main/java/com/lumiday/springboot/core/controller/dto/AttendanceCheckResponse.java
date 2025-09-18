package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.AttendanceType;
import com.lumiday.springboot.core.domain.invitation.vo.AttendanceCheckDomain;

public record AttendanceCheckResponse(String title,
                                      String content,
                                      String buttonText,
                                      AttendanceType type) {
    public static AttendanceCheckResponse of(AttendanceCheckDomain attendanceCheck) {
        return new AttendanceCheckResponse(
                attendanceCheck.getTitle(),
                attendanceCheck.getContent(),
                attendanceCheck.getButtonText(),
                attendanceCheck.getType()
        );
    }
}
