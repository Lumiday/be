package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.PersonRole;
import lombok.Getter;

@Getter
public class PersonInfoDomain {
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean isDeceased;
    private PersonRole role;

    public PersonInfoDomain(String firstName, String lastName, String phone, Boolean isDeceased, PersonRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.isDeceased = isDeceased;
        this.role = role;
    }
}
