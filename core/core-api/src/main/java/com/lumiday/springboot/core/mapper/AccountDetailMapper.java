package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AccountDetail;
import com.lumiday.springboot.core.controller.dto.AccountDetailRequest;
import com.lumiday.springboot.core.domain.invitation.vo.AccountDetailDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountDetailMapper {
    AccountDetailMapper INSTANCE = Mappers.getMapper(AccountDetailMapper.class);

    AccountDetail toEntity(AccountDetailDomain domain);

    AccountDetailDomain toDomain(AccountDetail entity);

    AccountDetailDomain toDomain(AccountDetailRequest request);
}
