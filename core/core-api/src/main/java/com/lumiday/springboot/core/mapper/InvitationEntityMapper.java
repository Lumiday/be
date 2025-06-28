package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;

public class InvitationEntityMapper {
    private InvitationEntityMapper() {
    }

    public static InvitationEntity toEntity(UserEntity userEntity) {
        return InvitationEntity.of(
                userEntity
        );
    }
}
