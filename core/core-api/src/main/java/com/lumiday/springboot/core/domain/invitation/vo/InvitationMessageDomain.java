package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.springboot.core.controller.dto.InvitationMessageRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InvitationMessageDomain {
    private String title;
    private String content;

    public static InvitationMessageDomain of(String title, String content) {
        return new InvitationMessageDomain(title, content);
    }

    public static InvitationMessageDomain of(InvitationMessageRequest request) {
        return new InvitationMessageDomain(request.title(), request.content());
    }
}
