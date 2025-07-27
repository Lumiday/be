package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.AccountDesignType;
import com.lumiday.springboot.core.controller.dto.AccountInfoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountInfoDomain {
    private String title;
    private String content;
    private AccountDesignType designType;
    private AccountGroupDomain groomAccountGroup;
    private AccountGroupDomain brideAccountGroup;

    public static AccountInfoDomain of(AccountInfoRequest request) {
        return new AccountInfoDomain(
                request.title(),
                request.content(),
                request.designType(),
                AccountGroupDomain.of(request.groomAccountGroup()),
                AccountGroupDomain.of(request.brideAccountGroup())
        );
    }

    public static AccountInfoDomain of(String title, String content, AccountDesignType designType,
                                       AccountGroupDomain groomAccountGroup, AccountGroupDomain brideAccountGroup) {
        return new AccountInfoDomain(
                title, content, designType, groomAccountGroup, brideAccountGroup
        );
    }
}
