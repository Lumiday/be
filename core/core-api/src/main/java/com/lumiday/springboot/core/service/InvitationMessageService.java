package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.InvitationMessageResponse;
import com.lumiday.springboot.core.domain.InvitationMessageDomain;
import com.lumiday.springboot.core.implement.persistence.InvitationMessagePersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationMessageService {

    private final InvitationMessagePersistence invitationMessagePersistence;

    public InvitationMessageResponse getInvitationMessageByInvitationId(String invitationId) {
        InvitationMessageDomain invitationMessageDomain = invitationMessagePersistence.getInvitationMessageByInvitationId(
                invitationId);

        return InvitationMessageResponse.of(invitationMessageDomain);
    }
}
