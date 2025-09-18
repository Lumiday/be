package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.InvitationMessage;
import com.lumiday.springboot.core.domain.invitation.vo.InvitationMessageDomain;

public class InvitationMessageEntityMapper {
    private InvitationMessageEntityMapper() {
    }

    public static InvitationMessage toEntity(InvitationMessageDomain domain) {
        return InvitationMessage.of(
                domain.getTitle(),
                domain.getContent()
        );
    }

    public static InvitationMessageDomain toDomain(InvitationMessage entity) {
        return InvitationMessageDomain.of(
                entity.getTitle(),
                entity.getContent()
        );
    }
}
