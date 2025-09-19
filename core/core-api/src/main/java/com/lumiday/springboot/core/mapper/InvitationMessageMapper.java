package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.InvitationMessage;
import com.lumiday.springboot.core.controller.dto.InvitationMessageRequest;
import com.lumiday.springboot.core.controller.dto.InvitationMessageResponse;
import com.lumiday.springboot.core.domain.invitation.vo.InvitationMessageDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvitationMessageMapper {
    InvitationMessageMapper INSTANCE = Mappers.getMapper(InvitationMessageMapper.class);

    InvitationMessage toEntity(InvitationMessageDomain domain);

    InvitationMessageDomain toDomain(InvitationMessage entity);

    InvitationMessageDomain toDomain(InvitationMessageRequest request);

    InvitationMessageResponse toResponse(InvitationMessageDomain invitationMessageDomain);
}
