package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AttendanceCheck;
import com.lumiday.springboot.core.domain.invitation.vo.AttendanceCheckDomain;

public class AttendanceCheckEntityMapper {

    private AttendanceCheckEntityMapper() {
    }

    public static AttendanceCheckDomain toDomain(AttendanceCheck attendanceCheck) {
        return AttendanceCheckDomain.of(
                attendanceCheck.getTitle(),
                attendanceCheck.getContent(),
                attendanceCheck.getButtonText(),
                attendanceCheck.getType()
        );
    }

    public static AttendanceCheck toEntity(AttendanceCheckDomain attendanceCheckDomain) {
        return AttendanceCheck.of(
                attendanceCheckDomain.getTitle(),
                attendanceCheckDomain.getContent(),
                attendanceCheckDomain.getButtonText(),
                attendanceCheckDomain.getType()
        );
    }
}
