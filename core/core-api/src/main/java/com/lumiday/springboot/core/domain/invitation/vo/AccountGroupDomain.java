package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.springboot.core.controller.dto.AccountGroupRequest;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountGroupDomain {
    private String groupName;
    private List<AccountDetailDomain> accountDetails;

    public static AccountGroupDomain of(AccountGroupRequest request) {
        List<AccountDetailDomain> accountDetails = request.accountDetails().stream()
                .map(AccountDetailDomain::of)
                .toList();
        return new AccountGroupDomain(request.groupName(), accountDetails);
    }

    public static AccountGroupDomain of(String groupName, List<AccountDetailDomain> accountDetails) {
        return new AccountGroupDomain(groupName, accountDetails);
    }
}
