package com.lumiday.springboot.core.controller.dto;

import java.time.LocalDateTime;

public record WeddingDateResponse(
        LocalDateTime weddingDateTime,
        Boolean displayCalendar,
        Boolean displayDDay
) {
}
