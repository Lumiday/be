package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.PersonBaseInfo;
import com.lumiday.springboot.core.controller.dto.PersonBaseInfoRequest;
import com.lumiday.springboot.core.controller.dto.PersonBasicInfoResponse;
import com.lumiday.springboot.core.domain.invitation.vo.PersonBaseInfoDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonBaseInfoMapper {
    PersonBaseInfoMapper INSTANCE = Mappers.getMapper(PersonBaseInfoMapper.class);

    PersonBaseInfo toEntity(PersonBaseInfoDomain domain);

    PersonBaseInfoDomain toDomain(PersonBaseInfo entity);

    PersonBaseInfoDomain toDomain(PersonBaseInfoRequest entity);

    PersonBasicInfoResponse toResponse(PersonBaseInfoDomain personBaseInfoDomain);
}