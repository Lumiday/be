package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;

@Entity
public class UserEntity extends BaseEntity {

    private String email;
    private String username;
}
