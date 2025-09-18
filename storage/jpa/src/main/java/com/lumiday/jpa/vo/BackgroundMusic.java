package com.lumiday.jpa.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BackgroundMusic {

    @Column(name = "bgm_music_name")
    private String musicName;

    @Column(name = "bgm_autoplay")
    private Boolean autoplay;

    public static BackgroundMusic of(String musicName, Boolean autoplay) {
        if (musicName == null) {
            throw new IllegalArgumentException("musicName은 필수입니다.");
        }
        BackgroundMusic bgm = new BackgroundMusic();
        bgm.musicName = musicName;
        bgm.autoplay = (autoplay != null) ? autoplay : Boolean.FALSE;
        return bgm;
    }
}
