package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.invitation.vo.AccountGroupDomain;
import java.util.List;

public record AccountGroupResponse(String groupName, List<AccountDetailResponse> accountDetails) {
    public static AccountGroupResponse of(AccountGroupDomain accountGroupDomain) {
        return new AccountGroupResponse(
                accountGroupDomain.getGroupName(),
                accountGroupDomain.getAccountDetails().stream().map(AccountDetailResponse::of).toList()
        );
    }
}
