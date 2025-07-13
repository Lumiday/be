package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.WeddingDateDomain;
import java.time.LocalDateTime;

public record WeddingDateResponse(
        LocalDateTime weddingDateTime,
        Boolean displayCalendar,
        Boolean displayDDay
) {

    public static WeddingDateResponse of(WeddingDateDomain weddingDateDomain) {
        return new WeddingDateResponse(
                weddingDateDomain.getWeddingDateTime(),
                weddingDateDomain.getDisplayCalendar(),
                weddingDateDomain.getDisplayDDay()
        );
    }
}
