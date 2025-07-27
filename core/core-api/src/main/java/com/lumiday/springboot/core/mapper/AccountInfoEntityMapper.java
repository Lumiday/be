package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.AccountInfoEntity;
import com.lumiday.springboot.core.domain.AccountInfoDomain;

public class AccountInfoEntityMapper {
    private AccountInfoEntityMapper() {
    }

    public static AccountInfoEntity toEntity(AccountInfoDomain accountInfoDomain) {
        return AccountInfoEntity.of(
                accountInfoDomain.getTitle(),
                accountInfoDomain.getContent(),
                accountInfoDomain.getDesignType(),
                AccountGroupEntityMapper.toEntity(accountInfoDomain.getGroomAccountGroup()),
                AccountGroupEntityMapper.toEntity(accountInfoDomain.getBrideAccountGroup())
        );
    }

    public static AccountInfoDomain toDomain(AccountInfoEntity accountInfoEntity) {
        return AccountInfoDomain.of(
                accountInfoEntity.getTitle(),
                accountInfoEntity.getContent(),
                accountInfoEntity.getDesignType(),
                AccountGroupEntityMapper.toDomain(accountInfoEntity.getGroomAccountGroup()),
                AccountGroupEntityMapper.toDomain(accountInfoEntity.getBrideAccountGroup())
        );
    }
}
