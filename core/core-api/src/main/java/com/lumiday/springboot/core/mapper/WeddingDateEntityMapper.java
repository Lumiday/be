package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.WeddingDateEntity;
import com.lumiday.springboot.core.domain.WeddingDateDomain;

public class WeddingDateEntityMapper {
    private WeddingDateEntityMapper() {
    }

    public static WeddingDateEntity toEntity(InvitationEntity invitationEntity, WeddingDateDomain domain) {
        return WeddingDateEntity.of(
                invitationEntity,
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
