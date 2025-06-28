package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;

public class InvitationEntityMapper {
    InvitationEntityMapper() {
    }

    InvitationEntity toEntity(UserEntity userEntity) {
        return InvitationEntity.of(
                userEntity
        );
    }
}
