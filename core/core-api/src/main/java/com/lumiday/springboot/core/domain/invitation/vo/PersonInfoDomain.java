package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.PersonRole;
import com.lumiday.springboot.core.controller.dto.PersonInfoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonInfoDomain {
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean isDeceased;
    private PersonRole role;

    public static PersonInfoDomain of(String firstName, String lastName, String phone, Boolean isDeceased,
                                      PersonRole role) {
        return new PersonInfoDomain(firstName, lastName, phone, isDeceased, role);
    }

    public static PersonInfoDomain of(PersonInfoRequest request) {
        return new PersonInfoDomain(
                request.firstName(),
                request.lastName(),
                request.phone(),
                request.isDeceased(),
                request.role()
        );
    }
}
