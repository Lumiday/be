package com.lumiday.jpa.vo;

import com.lumiday.core.enums.AttendanceType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendanceCheck {

    @Column(name = "attendance_check_title")
    private String title;

    @Column(name = "attendance_check_content")
    private String content;

    @Column(name = "attendance_button_text")
    private String buttonText;

    @Column(name = "attendance_type")
    @Enumerated(EnumType.STRING)
    private AttendanceType type;

    public static AttendanceCheck of(String title, String content, String buttonText, AttendanceType type) {
        if (title == null || content == null || buttonText == null || type == null) {
            throw new IllegalArgumentException("title, content, buttonText, type는 필수입니다.");
        }
        AttendanceCheck check = new AttendanceCheck();
        check.title = title;
        check.content = content;
        check.buttonText = buttonText;
        check.type = type;
        return check;
    }
}
