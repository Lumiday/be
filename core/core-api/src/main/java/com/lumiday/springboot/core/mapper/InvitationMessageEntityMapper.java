package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationMessageEntity;
import com.lumiday.springboot.core.domain.InvitationMessageDomain;

public class InvitationMessageEntityMapper {
    private InvitationMessageEntityMapper() {
    }

    public static InvitationMessageEntity toEntity(InvitationMessageDomain domain) {
        return InvitationMessageEntity.of(
                domain.getTitle(),
                domain.getContent()
        );
    }

    public static InvitationMessageDomain toDomain(InvitationMessageEntity entity) {
        return InvitationMessageDomain.of(
                entity.getTitle(),
                entity.getContent()
        );
    }
}
