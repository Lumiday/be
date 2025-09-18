package com.lumiday.springboot.core.domain.invitation.vo;

import lombok.Getter;

@Getter
public class InvitationMessageDomain {
    private String title;
    private String content;

    public InvitationMessageDomain(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
