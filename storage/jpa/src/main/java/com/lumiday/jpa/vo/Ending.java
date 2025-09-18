package com.lumiday.jpa.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ending {

    @Column(name = "endig_title")
    private String title;

    @Column(name = "endig_content")
    private String content;

    @Column(name = "endig_image_name")
    private String imageName;

    public Ending(String title, String content, String imageName) {
        if (title == null || content == null || imageName == null) {
            throw new IllegalArgumentException("title과 content와 image는 필수입니다.");
        }
        this.title = title;
        this.content = content;
        this.imageName = imageName;
    }
}
