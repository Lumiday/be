package com.lumiday.springboot.core.controller.dto;

public record AccountDetailRequest(
        String ownerName, String bankName, String accountNumber, Boolean kakaoPayEnabled
) {
}