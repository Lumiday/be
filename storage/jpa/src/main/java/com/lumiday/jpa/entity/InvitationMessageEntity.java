package com.lumiday.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "invitation_messages")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvitationMessageEntity extends BaseEntity {
    private String title;
    private String message;
}
