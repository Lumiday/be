package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.BackgroundMusic;
import com.lumiday.springboot.core.domain.invitation.vo.BackgroundMusicDomain;

public class BackgroundMusicEntityMapper {

    private BackgroundMusicEntityMapper() {
    }

    public static BackgroundMusic toEntity(BackgroundMusicDomain domain) {
        return BackgroundMusic.of(
                domain.getMusicName(),
                domain.getAutoPlay()
        );
    }

    public static BackgroundMusicDomain toDomain(BackgroundMusic entity) {
        return BackgroundMusicDomain.of(
                entity.getMusicName(),
                entity.getAutoplay()
        );
    }
}
