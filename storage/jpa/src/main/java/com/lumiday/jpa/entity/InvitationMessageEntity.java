package com.lumiday.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "invitation_messages")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvitationMessageEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private InvitationEntity invitation;

    private String title;
    private String content;

    private InvitationMessageEntity(InvitationEntity invitation, String title, String content) {
        this.invitation = invitation;
        this.title = title;
        this.content = content;
    }

    public static InvitationMessageEntity of(InvitationEntity invitation, String title, String content) {
        return new InvitationMessageEntity(invitation, title, content);
    }
}
