package com.lumiday.springboot.core.domain.invitation.vo;

import lombok.Getter;

@Getter
public class BackgroundMusicDomain {

    private String musicName;
    private Boolean autoplay;

    public BackgroundMusicDomain(String musicName, Boolean autoplay) {
        this.musicName = musicName;
        this.autoplay = autoplay;
    }
}
