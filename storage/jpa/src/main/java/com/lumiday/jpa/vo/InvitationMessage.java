package com.lumiday.jpa.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvitationMessage {

    @Column(name = "invitation_title")
    private String title;

    @Column(name = "invitation_content")
    private String content;

    public InvitationMessage(String title, String content) {
        if (title == null || content == null) {
            throw new IllegalArgumentException("title과 content는 필수입니다.");
        }
        this.title = title;
        this.content = content;
    }
}