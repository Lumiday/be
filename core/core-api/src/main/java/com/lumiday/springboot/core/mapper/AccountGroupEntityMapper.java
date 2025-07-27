package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.AccountGroupEntity;
import com.lumiday.springboot.core.domain.AccountGroupDomain;

public class AccountGroupEntityMapper {

    private AccountGroupEntityMapper() {
    }
    
    public static AccountGroupEntity toEntity(AccountGroupDomain accountGroupDomain) {
        return AccountGroupEntity.of(
                accountGroupDomain.getGroupName(),
                accountGroupDomain.getAccountDetails().stream()
                        .map(AccountDetailEntityMapper::toEntity)
                        .toList()
        );
    }

    public static AccountGroupDomain toDomain(AccountGroupEntity accountGroupEntity) {
        return AccountGroupDomain.of(
                accountGroupEntity.getGroupName(),
                accountGroupEntity.getAccountDetails().stream()
                        .map(AccountDetailEntityMapper::toDomain)
                        .toList()
        );
    }
}
