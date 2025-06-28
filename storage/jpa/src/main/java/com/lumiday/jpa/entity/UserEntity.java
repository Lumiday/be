package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {

    private String email;
    private String username;

    private UserEntity(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public static UserEntity of(String email, String username) {
        return new UserEntity(email, username);
    }
}
