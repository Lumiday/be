package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AttendanceCheck;
import com.lumiday.springboot.core.controller.dto.AttendanceCheckRequest;
import com.lumiday.springboot.core.domain.invitation.vo.AttendanceCheckDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttendanceCheckMapper {
    AttendanceCheckMapper INSTANCE = Mappers.getMapper(AttendanceCheckMapper.class);

    AttendanceCheck toEntity(AttendanceCheckDomain attendanceCheckDomain);

    AttendanceCheckDomain toDomain(AttendanceCheck attendanceCheck);

    AttendanceCheckDomain toDomain(AttendanceCheckRequest attendanceCheck);
}
