package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.PersonInfo;
import com.lumiday.springboot.core.domain.invitation.vo.PersonInfoDomain;

public class PersonInfoEntityMapper {
    private PersonInfoEntityMapper() {
    }

    public static PersonInfo toEntity(PersonInfoDomain domain) {
        return PersonInfo.of(
                domain.getRole(),
                domain.getFirstName(),
                domain.getLastName(),
                domain.getPhone(),
                domain.getIsDeceased()
        );
    }

    public static PersonInfoDomain toDomain(PersonInfo entity) {
        return PersonInfoDomain.of(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhone(),
                entity.getIsDeceased(),
                entity.getRole()
        );
    }
}
