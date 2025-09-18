package com.lumiday.springboot.core.domain.invitation.vo;

import lombok.Getter;

@Getter
public class AccountDetailDomain {
    private String ownerName;
    private String bankName;
    private String accountNumber;
    private Boolean kakaoPayEnabled;

    public AccountDetailDomain(String ownerName, String bankName, String accountNumber, Boolean kakaoPayEnabled) {
        this.ownerName = ownerName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.kakaoPayEnabled = kakaoPayEnabled;
    }
}
