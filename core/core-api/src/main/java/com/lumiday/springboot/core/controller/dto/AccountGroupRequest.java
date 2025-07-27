package com.lumiday.springboot.core.controller.dto;

import java.util.List;

public record AccountGroupRequest(String groupName, List<AccountDetailRequest> accountDetails) {
}
