package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.PersonRole;
import com.lumiday.springboot.core.domain.invitation.vo.PersonInfoDomain;

public record PersonInfoResponse(
        PersonRole role,
        String firstName,
        String lastName,
        String phone,
        Boolean isDeceased
) {
    public static PersonInfoResponse of(PersonInfoDomain domain) {
        return new PersonInfoResponse(
                domain.getRole(),
                domain.getFirstName(),
                domain.getLastName(),
                domain.getPhone(),
                domain.getIsDeceased()
        );
    }
}
