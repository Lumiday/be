package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.BackgroundMusicDomain;

public record BackgroundMusicResponse(String musicName, Boolean autoPlay) {
    public static BackgroundMusicResponse of(BackgroundMusicDomain backgroundMusic) {
        return new BackgroundMusicResponse(
                backgroundMusic.getMusicName(),
                backgroundMusic.getAutoPlay()
        );
    }
}
