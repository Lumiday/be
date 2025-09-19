package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AccountInfo;
import com.lumiday.springboot.core.controller.dto.AccountInfoRequest;
import com.lumiday.springboot.core.controller.dto.AccountInfoResponse;
import com.lumiday.springboot.core.domain.invitation.vo.AccountInfoDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountInfoMapper {
    AccountInfoMapper INSTANCE = Mappers.getMapper(AccountInfoMapper.class);

    AccountInfo toEntity(AccountInfoDomain accountInfoDomain);

    AccountInfoDomain toDomain(AccountInfo accountInfo);

    AccountInfoDomain toDomain(AccountInfoRequest accountInfo);

    AccountInfoResponse toResponse(AccountInfoDomain domain);
}
