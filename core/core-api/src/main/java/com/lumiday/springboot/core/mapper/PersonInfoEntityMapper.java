package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.PersonBaseInfoEntity;
import com.lumiday.jpa.entity.PersonInfoEntity;
import com.lumiday.springboot.core.domain.PersonInfoDomain;

public class PersonInfoEntityMapper {
    private PersonInfoEntityMapper() {
    }

    public static PersonInfoEntity toEntity(PersonBaseInfoEntity entity, PersonInfoDomain domain) {
        return PersonInfoEntity.of(
                entity,
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
