package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.AccountDetailEntity;
import com.lumiday.springboot.core.domain.AccountDetailDomain;

public class AccountDetailEntityMapper {

    private AccountDetailEntityMapper() {
    }

    public static AccountDetailEntity toEntity(AccountDetailDomain domain) {
        return AccountDetailEntity.of(
                domain.getOwnerName(),
                domain.getBankName(),
                domain.getAccountNumber(),
                domain.getKakaoPayEnabled()
        );
    }

    public static AccountDetailDomain toDomain(AccountDetailEntity entity) {
        return AccountDetailDomain.of(
                entity.getOwnerName(),
                entity.getBankName(),
                entity.getAccountNumber(),
                entity.getKakaoPayEnabled()
        );
    }
}
