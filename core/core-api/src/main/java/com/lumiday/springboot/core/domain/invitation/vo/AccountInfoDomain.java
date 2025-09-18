package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.AccountDesignType;
import lombok.Getter;

@Getter
public class AccountInfoDomain {
    private String title;
    private String content;
    private AccountDesignType designType;
    private AccountGroupDomain groomAccountGroup;
    private AccountGroupDomain brideAccountGroup;

    public AccountInfoDomain(String title, String content, AccountDesignType designType,
                             AccountGroupDomain groomAccountGroup, AccountGroupDomain brideAccountGroup) {
        this.title = title;
        this.content = content;
        this.designType = designType;
        this.groomAccountGroup = groomAccountGroup;
        this.brideAccountGroup = brideAccountGroup;
    }
}
