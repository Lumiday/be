package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.InvitationMessageDomain;

public record InvitationMessageResponse(
        String title,
        String content
) {
    public static InvitationMessageResponse of(InvitationMessageDomain domain) {
        return new InvitationMessageResponse(
                domain.getTitle(),
                domain.getContent()
        );
    }
}
