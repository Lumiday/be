package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.AccountDetail;
import com.lumiday.springboot.core.domain.invitation.vo.AccountDetailDomain;

//@Mapper
//public interface AccountDetailEntityMapper {
//    AccountDetailEntityMapper INSTANCE = Mappers.getMapper(AccountDetailEntityMapper.class);
//
//    AccountDetail toEntity(AccountDetailDomain domain);
//
//    AccountDetailDomain toDomain(AccountDetail entity);
//
//    @ObjectFactory
//    default AccountDetailDomain createDomain(String ownerName, String bankName, String accountNumber,
//                                             Boolean kakaoPayEnabled) {
//        return AccountDetailDomain.of(ownerName, bankName, accountNumber, kakaoPayEnabled);
//    }
//}


public class AccountDetailEntityMapper {

    private AccountDetailEntityMapper() {
    }

    public static AccountDetail toEntity(AccountDetailDomain domain) {
        return AccountDetail.of(
                domain.getOwnerName(),
                domain.getBankName(),
                domain.getAccountNumber(),
                domain.getKakaoPayEnabled()
        );
    }

    public static AccountDetailDomain toDomain(AccountDetail entity) {
        return AccountDetailDomain.of(
                entity.getOwnerName(),
                entity.getBankName(),
                entity.getAccountNumber(),
                entity.getKakaoPayEnabled()
        );
    }
}
