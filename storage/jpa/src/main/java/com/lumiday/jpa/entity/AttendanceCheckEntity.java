package com.lumiday.jpa.entity;

import com.lumiday.core.enums.AttendanceType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "attendance_checks")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AttendanceCheckEntity extends BaseEntity {
    private String title;
    private String content;
    private String buttonText;
    private AttendanceType type;
}
