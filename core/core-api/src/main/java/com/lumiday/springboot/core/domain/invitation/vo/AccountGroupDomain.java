package com.lumiday.springboot.core.domain.invitation.vo;

import java.util.List;
import lombok.Getter;

@Getter
public class AccountGroupDomain {
    private String name;
    private List<AccountDetailDomain> accountDetails;

    public AccountGroupDomain(String name, List<AccountDetailDomain> accountDetails) {
        this.name = name;
        this.accountDetails = accountDetails;
    }
}
