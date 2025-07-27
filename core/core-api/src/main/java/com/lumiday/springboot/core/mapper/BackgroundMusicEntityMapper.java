package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.BackgroundMusicEntity;
import com.lumiday.springboot.core.domain.BackgroundMusicDomain;

public class BackgroundMusicEntityMapper {

    private BackgroundMusicEntityMapper() {
    }

    public static BackgroundMusicEntity toEntity(BackgroundMusicDomain domain) {
        return BackgroundMusicEntity.of(
                domain.getMusicName(),
                domain.getAutoPlay()
        );
    }

    public static BackgroundMusicDomain toDomain(BackgroundMusicEntity entity) {
        return BackgroundMusicDomain.of(
                entity.getMusicName(),
                entity.getAutoPlay()
        );
    }
}
