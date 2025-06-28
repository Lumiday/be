package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.domain.ThemeDomain;
import com.lumiday.springboot.core.domain.UserDomain;
import com.lumiday.springboot.core.implement.persistence.InvitationPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationPersistence invitationPersistence;

    public String createInvitation(CreateInvitationRequest request) {
        UserDomain user = UserDomain.of();
        ThemeDomain themeDomain = ThemeDomain.of(request.theme());
        return invitationPersistence.saveInvitation(user, themeDomain);
    }
}
