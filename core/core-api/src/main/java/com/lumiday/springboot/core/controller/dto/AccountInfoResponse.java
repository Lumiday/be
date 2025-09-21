package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.AccountDesignType;

public record AccountInfoResponse(String title, String content, AccountDesignType designType,
                                  AccountGroupResponse groomAccountGroup, AccountGroupResponse brideAccountGroup) {
}
