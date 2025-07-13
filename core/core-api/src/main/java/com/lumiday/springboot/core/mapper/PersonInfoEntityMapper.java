package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.PersonInfoEntity;
import com.lumiday.springboot.core.domain.PersonInfoDomain;

public class PersonInfoEntityMapper {
    private PersonInfoEntityMapper() {
    }

    public static PersonInfoEntity toEntity(InvitationEntity invitationEntity, PersonInfoDomain domain) {
        return PersonInfoEntity.of(
                invitationEntity,
                domain.getRole(),
                domain.getFirstName(),
                domain.getLastName(),
                domain.getPhone(),
                domain.getIsDeceased()
        );
    }

    public static PersonInfoDomain toDomain(PersonInfoEntity entity) {
        return PersonInfoDomain.of(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhone(),
                entity.getIsDeceased(),
                entity.getRole()
        );
    }
}
