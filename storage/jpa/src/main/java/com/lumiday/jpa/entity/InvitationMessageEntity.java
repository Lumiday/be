package com.lumiday.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "invitation_messages")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InvitationMessageEntity extends BaseEntity {
    private String title;
    private String content;

    public static InvitationMessageEntity of(String title, String content) {
        return new InvitationMessageEntity(title, content);
    }
}
