package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.domain.IntroLayoutDomain;
import com.lumiday.springboot.core.domain.InvitationDomain;
import com.lumiday.springboot.core.domain.InvitationMessageDomain;
import com.lumiday.springboot.core.domain.PersonBaseInfoDomain;
import com.lumiday.springboot.core.domain.ThemeDomain;
import com.lumiday.springboot.core.domain.UserDomain;
import com.lumiday.springboot.core.domain.WeddingDateDomain;
import com.lumiday.springboot.core.domain.WeddingPlaceDomain;
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
        IntroLayoutDomain introLayoutDomain = IntroLayoutDomain.of(request.introLayout());
        PersonBaseInfoDomain personBaseInfoDomain = PersonBaseInfoDomain.of(request.personBasicInfoRequest());
        WeddingDateDomain weddingDateDomain = WeddingDateDomain.of(request.weddingDateRequest());
        WeddingPlaceDomain weddingPlaceDomain = WeddingPlaceDomain.of(request.weddingPlaceRequest());
        InvitationMessageDomain invitationMessageDomain = InvitationMessageDomain.of(
                request.invitationMessageRequest());

        InvitationDomain invitationDomain = InvitationDomain.of(
                user, introLayoutDomain, themeDomain,
                personBaseInfoDomain, weddingDateDomain,
                weddingPlaceDomain, invitationMessageDomain);
        return invitationPersistence.saveInvitation(invitationDomain);
    }
}
