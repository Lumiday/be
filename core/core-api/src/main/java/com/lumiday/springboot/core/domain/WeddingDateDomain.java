package com.lumiday.springboot.core.domain;

import com.lumiday.springboot.core.controller.dto.WeddingDateRequest;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WeddingDateDomain {
    private LocalDateTime weddingDateTime;
    private Boolean displayCalendar;
    private Boolean displayDDay;

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
