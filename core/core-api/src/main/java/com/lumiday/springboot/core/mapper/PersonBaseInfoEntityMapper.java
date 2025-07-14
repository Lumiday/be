package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.PersonBaseInfoEntity;
import com.lumiday.springboot.core.domain.PersonBaseInfoDomain;

public class PersonBaseInfoEntityMapper {
    private PersonBaseInfoEntityMapper() {
    }

    public static PersonBaseInfoEntity toEntity(PersonBaseInfoDomain domain) {
        PersonBaseInfoEntity personBaseInfoEntity = PersonBaseInfoEntity.of(domain.getDeceasedDisplayType());

        domain.getPersonInfoList().forEach(personInfo -> personBaseInfoEntity.addPersonInfo(
                PersonInfoEntityMapper.toEntity(personBaseInfoEntity, personInfo)
        ));

        return personBaseInfoEntity;
    }

    public static PersonBaseInfoDomain toDomain(PersonBaseInfoEntity entity) {
        return PersonBaseInfoDomain.of(
                entity.getDeceasedDisplayType(),
                entity.getPersonInfoList().stream().map(PersonInfoEntityMapper::toDomain).
                        toList()
        );
    }
}
