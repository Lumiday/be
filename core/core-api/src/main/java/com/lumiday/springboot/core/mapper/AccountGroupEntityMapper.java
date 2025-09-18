package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AccountGroup;
import com.lumiday.springboot.core.domain.invitation.vo.AccountGroupDomain;

public class AccountGroupEntityMapper {

    private AccountGroupEntityMapper() {
    }

    public static AccountGroup toEntity(AccountGroupDomain accountGroupDomain) {
        return AccountGroup.of(
                accountGroupDomain.getGroupName(),
                accountGroupDomain.getAccountDetails().stream()
                        .map(AccountDetailEntityMapper::toEntity)
                        .toList()
        );
    }

    public static AccountGroupDomain toDomain(AccountGroup accountGroup) {
        return AccountGroupDomain.of(
                accountGroup.getName(),
                accountGroup.getAccountDetails().stream()
                        .map(AccountDetailEntityMapper::toDomain)
                        .toList()
        );
    }
}
