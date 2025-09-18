package com.lumiday.springboot.core.domain.invitation.vo;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class WeddingDateDomain {
    private LocalDateTime weddingDateTime;
    private Boolean displayCalendar;
    private Boolean displayDDay;

    public WeddingDateDomain(LocalDateTime weddingDateTime, Boolean displayCalendar, Boolean displayDDay) {
        this.weddingDateTime = weddingDateTime;
        this.displayCalendar = displayCalendar;
        this.displayDDay = displayDDay;
    }
}
