package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.AttendanceCheckEntity;
import com.lumiday.springboot.core.domain.AttendanceCheckDomain;

public class AttendanceCheckEntityMapper {

    private AttendanceCheckEntityMapper() {
    }

    public static AttendanceCheckDomain toDomain(AttendanceCheckEntity attendanceCheckEntity) {
        return AttendanceCheckDomain.of(
                attendanceCheckEntity.getTitle(),
                attendanceCheckEntity.getContent(),
                attendanceCheckEntity.getButtonText(),
                attendanceCheckEntity.getType()
        );
    }

    public static AttendanceCheckEntity toEntity(AttendanceCheckDomain attendanceCheckDomain) {
        return AttendanceCheckEntity.of(
                attendanceCheckDomain.getTitle(),
                attendanceCheckDomain.getContent(),
                attendanceCheckDomain.getButtonText(),
                attendanceCheckDomain.getType()
        );
    }
}
