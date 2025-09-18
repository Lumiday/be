package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.springboot.core.controller.dto.BackgroundMusicRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BackgroundMusicDomain {

    private String musicName;
    private Boolean autoPlay;

    public static BackgroundMusicDomain of(BackgroundMusicRequest request) {
        return new BackgroundMusicDomain(
                request.musicName(),
                request.autoPlay()
        );
    }

    public static BackgroundMusicDomain of(String musicName, Boolean autoPlay) {
        return new BackgroundMusicDomain(
                musicName,
                autoPlay
        );
    }
}
