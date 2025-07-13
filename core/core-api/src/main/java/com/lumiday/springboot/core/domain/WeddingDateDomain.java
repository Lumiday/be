package com.lumiday.springboot.core.domain;

import com.lumiday.springboot.core.controller.dto.WeddingDateRequest;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class WeddingDateDomain {
    private LocalDateTime weddingDateTime;
    private Boolean displayCalendar;
    private Boolean displayDDay;

    private WeddingDateDomain(LocalDateTime weddingDateTime, Boolean displayCalendar, Boolean displayDDay) {
        this.weddingDateTime = weddingDateTime;
        this.displayCalendar = displayCalendar;
        this.displayDDay = displayDDay;
    }

    public static WeddingDateDomain of(LocalDateTime weddingDateTime, Boolean displayCalendar, Boolean displayDDay) {
        return new WeddingDateDomain(weddingDateTime, displayCalendar, displayDDay);
    }

    public static WeddingDateDomain of(WeddingDateRequest request) {
        return new WeddingDateDomain(
                request.weddingDateTime(),
                request.displayCalendar(),
                request.displayDDay()
        );
    }
}
