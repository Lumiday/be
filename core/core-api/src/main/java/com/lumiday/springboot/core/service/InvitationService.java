package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.controller.dto.InvitationResponse;
import com.lumiday.springboot.core.domain.UserDomain;
import com.lumiday.springboot.core.domain.invitation.aggregate.InvitationDomain;
import com.lumiday.springboot.core.implement.persistence.InvitationPersistence;
import com.lumiday.springboot.core.mapper.InvitationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationPersistence invitationPersistence;

    public String createInvitation(CreateInvitationRequest request) {
        UserDomain user = UserDomain.of();
        InvitationDomain invitationDomain = InvitationMapper.INSTANCE.toDomain(user, request);

        return invitationPersistence.saveInvitation(invitationDomain);
    }

    public InvitationResponse getInvitationBy(String invitationId) {
        InvitationDomain invitation = invitationPersistence.getInvitationById(invitationId);
        return InvitationResponse.of(invitation);
    }
}
