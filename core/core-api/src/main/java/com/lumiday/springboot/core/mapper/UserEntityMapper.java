package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.springboot.core.domain.UserDomain;

public class UserEntityMapper {
    private UserEntityMapper() {
    }

    public static UserEntity toEntity(UserDomain domain) {
        return UserEntity.of(
                domain.getEmail(),
                domain.getUsername()
        );
    }

    public static UserDomain toDomain(UserEntity entity) {
        return UserDomain.of(
                entity.getEmail(),
                entity.getUsername()
        );
    }
}
