package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity {

    private String email;
    private String username;
}
