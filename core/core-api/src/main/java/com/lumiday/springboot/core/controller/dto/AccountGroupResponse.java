package com.lumiday.springboot.core.controller.dto;

import java.util.List;

public record AccountGroupResponse(String name, List<AccountDetailResponse> accountDetails) {
}
