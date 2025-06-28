package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "person_informations")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonInfoEntity extends BaseEntity {
    private String role;
    private String name;
    private String phone;
    private Boolean isDeceased;
}
