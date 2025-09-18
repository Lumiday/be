package com.lumiday.springboot.core.controller.dto;

import java.util.List;

public record AccountGroupRequest(String name, List<AccountDetailRequest> accountDetails) {
}
