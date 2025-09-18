package com.lumiday.springboot.core.domain.invitation.vo;

import lombok.Getter;

@Getter
public class EndingDomain {
    private String title;
    private String content;
    private String imageName;

    public EndingDomain(String title, String content, String imageName) {
        this.title = title;
        this.content = content;
        this.imageName = imageName;
    }
}
