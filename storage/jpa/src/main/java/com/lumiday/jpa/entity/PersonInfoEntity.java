package com.lumiday.jpa.entity;

import com.lumiday.core.enums.PersonRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "person_informations")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonInfoEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "person_base_info_id")
    private PersonBaseInfoEntity personBaseInfo;

    @Enumerated(EnumType.STRING)
    private PersonRole role;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean isDeceased;

    public static PersonInfoEntity of(PersonBaseInfoEntity personBaseInfo, PersonRole role, String firstName,
                                      String lastName,
                                      String phone, Boolean isDeceased) {
        return new PersonInfoEntity(personBaseInfo, role, firstName, lastName, phone, isDeceased);
    }
}
