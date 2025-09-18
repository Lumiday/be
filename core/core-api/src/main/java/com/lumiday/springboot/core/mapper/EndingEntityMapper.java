package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.Ending;
import com.lumiday.springboot.core.domain.invitation.vo.EndingDomain;

public class EndingEntityMapper {

    private EndingEntityMapper() {
    }

    public static Ending toEntity(EndingDomain domain) {
        return Ending.of(
                domain.getTitle(),
                domain.getContent(),
                domain.getImageName()
        );
    }

    public static EndingDomain toDomain(Ending entity) {
        return EndingDomain.of(
                entity.getTitle(),
                entity.getContent(),
                entity.getImageName()
        );
    }
}
