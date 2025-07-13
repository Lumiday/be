package com.lumiday.jpa.entity;

import com.lumiday.core.enums.PersonRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "person_informations")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonInfoEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private InvitationEntity invitation;
    @Enumerated(EnumType.STRING)
    private PersonRole role;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean isDeceased;

    private PersonInfoEntity(InvitationEntity invitation, PersonRole role, String firstName, String lastName,
                             String phone, Boolean isDeceased) {
        this.invitation = invitation;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.isDeceased = isDeceased;
    }

    public static PersonInfoEntity of(InvitationEntity invitation, PersonRole role, String firstName, String lastName,
                                      String phone, Boolean isDeceased) {
        return new PersonInfoEntity(invitation, role, firstName, lastName, phone, isDeceased);
    }
}
