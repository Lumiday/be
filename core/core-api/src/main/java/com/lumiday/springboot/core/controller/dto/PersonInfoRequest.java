package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.PersonRole;

public record PersonInfoRequest(
        PersonRole role,
        String firstName,
        String lastName,
        String phone,
        Boolean isDeceased
) {
}
