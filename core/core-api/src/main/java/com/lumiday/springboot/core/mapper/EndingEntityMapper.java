package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.EndingEntity;
import com.lumiday.springboot.core.domain.EndingDomain;

public class EndingEntityMapper {

    private EndingEntityMapper() {
    }

    public static EndingEntity toEntity(EndingDomain domain) {
        return EndingEntity.of(
                domain.getTitle(),
                domain.getContent(),
                domain.getImageName()
        );
    }

    public static EndingDomain toDomain(EndingEntity entity) {
        return EndingDomain.of(
                entity.getTitle(),
                entity.getContent(),
                entity.getImageName()
        );
    }
}
