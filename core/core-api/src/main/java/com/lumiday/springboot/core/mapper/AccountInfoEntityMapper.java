package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AccountInfo;
import com.lumiday.springboot.core.domain.invitation.vo.AccountInfoDomain;

public class AccountInfoEntityMapper {
    private AccountInfoEntityMapper() {
    }

    public static AccountInfo toEntity(AccountInfoDomain accountInfoDomain) {
        return AccountInfo.of(
                accountInfoDomain.getTitle(),
                accountInfoDomain.getContent(),
                accountInfoDomain.getDesignType(),
                AccountGroupEntityMapper.toEntity(accountInfoDomain.getGroomAccountGroup()),
                AccountGroupEntityMapper.toEntity(accountInfoDomain.getBrideAccountGroup())
        );
    }

    public static AccountInfoDomain toDomain(AccountInfo accountInfo) {
        return AccountInfoDomain.of(
                accountInfo.getTitle(),
                accountInfo.getContent(),
                accountInfo.getDesignType(),
                AccountGroupEntityMapper.toDomain(accountInfo.getGroomAccountGroup()),
                AccountGroupEntityMapper.toDomain(accountInfo.getBrideAccountGroup())
        );
    }
}
