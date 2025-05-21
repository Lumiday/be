package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "users")
@Getter
@Entity
public class UserEntity extends BaseEntity {

    private String email;
    private String username;
}
