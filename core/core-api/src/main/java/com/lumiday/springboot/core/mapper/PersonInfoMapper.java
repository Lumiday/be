package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.PersonInfo;
import com.lumiday.springboot.core.controller.dto.PersonInfoRequest;
import com.lumiday.springboot.core.domain.invitation.vo.PersonInfoDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonInfoMapper {
    PersonInfoMapper INSTANCE = Mappers.getMapper(PersonInfoMapper.class);

    PersonInfo toEntity(PersonInfoDomain domain);

    PersonInfoDomain toDomain(PersonInfo entity);

    PersonInfoDomain toDomain(PersonInfoRequest entity);
}
