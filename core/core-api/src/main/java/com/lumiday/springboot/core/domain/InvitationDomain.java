package com.lumiday.springboot.core.domain;

import lombok.Getter;

@Getter
public class InvitationDomain {
    UserDomain user;

    private InvitationDomain(UserDomain user) {
        this.user = user;
    }

    public static InvitationDomain of(UserDomain user) {
        return new InvitationDomain(user);
    }
}
