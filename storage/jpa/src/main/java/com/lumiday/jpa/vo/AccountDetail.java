package com.lumiday.jpa.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class AccountDetail {

    @Column(name = "account_owner_name")
    private String ownerName;

    @Column(name = "account_bank_name")
    private String bankName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_kakao_pay_enabled")
    private Boolean kakaoPayEnabled;

    public AccountDetail(String ownerName, String bankName, String accountNumber, Boolean kakaoPayEnabled) {
        if (ownerName == null || bankName == null || accountNumber == null) {
            throw new IllegalArgumentException("계좌 소유자, 은행명, 계좌번호는 필수입니다.");
        }
        this.ownerName = ownerName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.kakaoPayEnabled = kakaoPayEnabled;
    }
}