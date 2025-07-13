package com.lumiday.springboot.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDomain {
    private String email;
    private String username;

    public static UserDomain of(String email, String username) {
        return new UserDomain(email, username);
    }

    public static UserDomain of() {
        return new UserDomain("test@test.com", "testUser");
    }
}
