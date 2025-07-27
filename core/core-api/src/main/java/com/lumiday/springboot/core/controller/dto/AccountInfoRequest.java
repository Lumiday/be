package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.AccountDesignType;

public record AccountInfoRequest(String title, String content, AccountDesignType designType,
                                 AccountGroupRequest groomAccountGroup, AccountGroupRequest brideAccountGroup) {
}
