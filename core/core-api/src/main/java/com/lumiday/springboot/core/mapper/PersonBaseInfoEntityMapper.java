package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.PersonBaseInfo;
import com.lumiday.springboot.core.domain.invitation.vo.PersonBaseInfoDomain;
import java.util.List;

public class PersonBaseInfoEntityMapper {
    private PersonBaseInfoEntityMapper() {
    }

    public static PersonBaseInfo toEntity(PersonBaseInfoDomain domain) {
        PersonBaseInfo personBaseInfoEntity = PersonBaseInfo.of(domain.getDeceasedDisplayType(), List.of());
//
//        domain.getPersonInfoList().forEach(personInfo -> personBaseInfoEntity.addPersonInfo(
//                PersonInfoEntityMapper.toEntity(personBaseInfoEntity, personInfo)
//        ));

        return personBaseInfoEntity;
    }

    public static PersonBaseInfoDomain toDomain(PersonBaseInfo entity) {
        return PersonBaseInfoDomain.of(
                entity.getDeceasedDisplayType(),
                entity.getPersonInfos().stream().map(PersonInfoEntityMapper::toDomain).
                        toList()
        );
    }
}
