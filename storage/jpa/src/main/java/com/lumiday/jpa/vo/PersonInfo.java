package com.lumiday.jpa.vo;

import com.lumiday.core.enums.PersonRole;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonInfo {

    @Column(name = "person_role")
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @Column(name = "person_first_name")
    private String firstName;

    @Column(name = "person_last_name")
    private String lastName;

    @Column(name = "person_phone")
    private String phone;

    @Column(name = "person_is_deceased")
    private Boolean isDeceased;

    public static PersonInfo of(PersonRole role, String firstName, String lastName, String phone, Boolean isDeceased) {
        if (role == null) {
            throw new IllegalArgumentException("role은 필수입니다.");
        }
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("firstName과 lastName은 필수입니다.");
        }

        PersonInfo info = new PersonInfo();
        info.role = role;
        info.firstName = firstName;
        info.lastName = lastName;
        info.phone = phone;
        info.isDeceased = isDeceased == null ? Boolean.FALSE : isDeceased;
        return info;
    }
}
