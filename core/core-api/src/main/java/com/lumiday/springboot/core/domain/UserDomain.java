package com.lumiday.springboot.core.domain;

import lombok.Getter;

@Getter
public class UserDomain {
    private String email;
    private String username;

    private UserDomain(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public static UserDomain of(String email, String username) {
        return new UserDomain(email, username);
    }

    public static UserDomain of() {
        return new UserDomain("test@test.com", "testUser");
    }
}
