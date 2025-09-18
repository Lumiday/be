package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.AccountDesignType;
import com.lumiday.springboot.core.domain.invitation.vo.AccountInfoDomain;

public record AccountInfoResponse(String title, String content, AccountDesignType designType,
                                  AccountGroupResponse groomAccountGroup, AccountGroupResponse brideAccountGroup) {

    public static AccountInfoResponse of(AccountInfoDomain accountInfoDomain) {

        return new AccountInfoResponse(
                accountInfoDomain.getTitle(),
                accountInfoDomain.getContent(),
                accountInfoDomain.getDesignType(),
                AccountGroupResponse.of(accountInfoDomain.getGroomAccountGroup()),
                AccountGroupResponse.of(accountInfoDomain.getBrideAccountGroup())
        );
    }
}
