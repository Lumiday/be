package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.PersonRole;
import com.lumiday.springboot.core.controller.dto.PersonInfoRequest;
import lombok.Getter;

@Getter
public class PersonInfoDomain {
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean isDeceased;
    private PersonRole role;

    private PersonInfoDomain(String firstName, String lastName, String phone, Boolean isDeceased, PersonRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.isDeceased = isDeceased;
        this.role = role;
    }

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
