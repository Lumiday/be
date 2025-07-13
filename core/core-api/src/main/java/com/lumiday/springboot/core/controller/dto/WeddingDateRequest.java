package com.lumiday.springboot.core.controller.dto;

import java.time.LocalDateTime;

public record WeddingDateRequest(
        LocalDateTime weddingDateTime,
        Boolean displayCalendar,
        Boolean displayDDay
) {
}
