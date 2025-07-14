package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.WeddingDateEntity;
import com.lumiday.springboot.core.domain.WeddingDateDomain;

public class WeddingDateEntityMapper {
    private WeddingDateEntityMapper() {
    }

    public static WeddingDateEntity toEntity(WeddingDateDomain domain) {
        return WeddingDateEntity.of(
                domain.getWeddingDateTime(),
                domain.getDisplayCalendar(),
                domain.getDisplayDDay()
        );
    }

    public static WeddingDateDomain toDomain(WeddingDateEntity weddingDateEntity) {
        return WeddingDateDomain.of(
                weddingDateEntity.getWeddingDateTime(),
                weddingDateEntity.getDisplayCalendar(),
                weddingDateEntity.getDisplayDDay()
        );
    }
}
