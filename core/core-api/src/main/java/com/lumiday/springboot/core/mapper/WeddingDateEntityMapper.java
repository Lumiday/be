package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.WeddingDate;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingDateDomain;

public class WeddingDateEntityMapper {
    private WeddingDateEntityMapper() {
    }

    public static WeddingDate toEntity(WeddingDateDomain domain) {
        return WeddingDate.of(
                domain.getWeddingDateTime(),
                domain.getDisplayCalendar(),
                domain.getDisplayDDay()
        );
    }

    public static WeddingDateDomain toDomain(WeddingDate weddingDate) {
        return WeddingDateDomain.of(
                weddingDate.getWeddingDateTime(),
                weddingDate.getDisplayCalendar(),
                weddingDate.getDisplayDDay()
        );
    }
}
