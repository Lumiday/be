package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.invitation.vo.AccountDetailDomain;

public record AccountDetailResponse(
        String ownerName, String bankName, String accountNumber, Boolean kakaoPayEnabled
) {
    public static AccountDetailResponse of(AccountDetailDomain accountDetailDomain) {
        return new AccountDetailResponse(
                accountDetailDomain.getOwnerName(),
                accountDetailDomain.getBankName(),
                accountDetailDomain.getAccountNumber(),
                accountDetailDomain.getKakaoPayEnabled()
        );
    }
}