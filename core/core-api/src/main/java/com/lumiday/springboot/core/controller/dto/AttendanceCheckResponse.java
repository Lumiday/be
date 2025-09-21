package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.AttendanceType;

public record AttendanceCheckResponse(String title,
                                      String content,
                                      String buttonText,
                                      AttendanceType type) {
}
