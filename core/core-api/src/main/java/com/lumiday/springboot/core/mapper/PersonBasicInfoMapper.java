package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.PersonBasicInfo;
import com.lumiday.springboot.core.controller.dto.PersonBasicInfoRequest;
import com.lumiday.springboot.core.controller.dto.PersonBasicInfoResponse;
import com.lumiday.springboot.core.domain.invitation.vo.PersonBasicInfoDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonBasicInfoMapper {
    PersonBasicInfoMapper INSTANCE = Mappers.getMapper(PersonBasicInfoMapper.class);

    PersonBasicInfo toEntity(PersonBasicInfoDomain domain);

    PersonBasicInfoDomain toDomain(PersonBasicInfo entity);

    PersonBasicInfoDomain toDomain(PersonBasicInfoRequest entity);

    PersonBasicInfoResponse toResponse(PersonBasicInfoDomain personBasicInfoDomain);
}