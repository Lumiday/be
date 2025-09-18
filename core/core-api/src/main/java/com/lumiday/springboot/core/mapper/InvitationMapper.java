package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.domain.UserDomain;
import com.lumiday.springboot.core.domain.invitation.aggregate.InvitationDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvitationMapper {
    InvitationMapper INSTANCE = Mappers.getMapper(InvitationMapper.class);

    InvitationEntity toEntity(UserEntity user);

    @Mapping(target = "user", source = "user")
    InvitationEntity toEntity(UserEntity user, InvitationDomain invitationDomain);

    InvitationDomain toDomain(InvitationEntity invitationEntity);

    InvitationDomain toDomain(UserDomain user, CreateInvitationRequest request);
}
