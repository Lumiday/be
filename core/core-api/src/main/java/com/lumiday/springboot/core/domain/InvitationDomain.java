package com.lumiday.springboot.core.domain;

import lombok.Getter;

@Getter
public class InvitationDomain {
    UserDomain user;
    IntroLayoutDomain introLayout;
    ThemeDomain theme;

    private InvitationDomain(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme) {
        this.user = user;
        this.introLayout = introLayout;
        this.theme = theme;
    }

    public static InvitationDomain of(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme) {
        return new InvitationDomain(user, introLayout, theme);
    }
}
