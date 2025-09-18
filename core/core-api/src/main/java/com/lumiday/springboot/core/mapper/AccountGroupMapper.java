package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AccountGroup;
import com.lumiday.springboot.core.controller.dto.AccountGroupRequest;
import com.lumiday.springboot.core.domain.invitation.vo.AccountGroupDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountGroupMapper {

    AccountGroupMapper INSTANCE = Mappers.getMapper(AccountGroupMapper.class);

    AccountGroup toEntity(AccountGroupDomain accountGroupDomain);

    AccountGroupDomain toDomain(AccountGroup accountGroup);

    AccountGroupDomain toDomain(AccountGroupRequest accountGroup);
}
