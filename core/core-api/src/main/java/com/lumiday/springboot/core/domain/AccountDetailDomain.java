package com.lumiday.springboot.core.domain;

import com.lumiday.springboot.core.controller.dto.AccountDetailRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDetailDomain {
    private String ownerName;
    private String bankName;
    private String accountNumber;
    private Boolean kakaoPayEnabled;

    public static AccountDetailDomain of(AccountDetailRequest request) {
        return new AccountDetailDomain(
                request.ownerName(),
                request.bankName(),
                request.accountNumber(),
                request.kakaoPayEnabled()
        );
    }

    public static AccountDetailDomain of(String ownerName, String bankName, String accountNumber,
                                         Boolean kakaoPayEnabled) {
        return new AccountDetailDomain(
                ownerName,
                bankName,
                accountNumber,
                kakaoPayEnabled
        );
    }
}
