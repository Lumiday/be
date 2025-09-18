package com.lumiday.springboot.core.domain.invitation.vo;

import lombok.Getter;

@Getter
public class BackgroundMusicDomain {

    private String musicName;
    private Boolean autoPlay;

    public BackgroundMusicDomain(String musicName, Boolean autoPlay) {
        this.musicName = musicName;
        this.autoPlay = autoPlay;
    }
}
