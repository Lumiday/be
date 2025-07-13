package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.domain.IntroLayoutDomain;
import com.lumiday.springboot.core.domain.InvitationDomain;
import com.lumiday.springboot.core.domain.PersonInfoDomain;
import com.lumiday.springboot.core.domain.ThemeDomain;
import com.lumiday.springboot.core.domain.UserDomain;
import com.lumiday.springboot.core.domain.WeddingDateDomain;
import com.lumiday.springboot.core.domain.WeddingPlaceDomain;
import com.lumiday.springboot.core.implement.persistence.InvitationPersistence;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationPersistence invitationPersistence;

    // TODO 리팩토링이 필요해보임 personBasicInfo를 객체로 만드는게 좋을까?
    public String createInvitation(CreateInvitationRequest request) {
        UserDomain user = UserDomain.of();

        ThemeDomain themeDomain = ThemeDomain.of(request.theme());
        IntroLayoutDomain introLayoutDomain = IntroLayoutDomain.of(request.introLayout());
        List<PersonInfoDomain> personInfoDomainList = request.personBasicInfoRequest().personInfoList().stream()
                .map(PersonInfoDomain::of)
                .toList();
        WeddingDateDomain weddingDateDomain = WeddingDateDomain.of(request.weddingDateRequest());
        WeddingPlaceDomain weddingPlaceDomain = WeddingPlaceDomain.of(request.weddingPlaceRequest());

        InvitationDomain invitationDomain = InvitationDomain.of(user, introLayoutDomain, themeDomain,
                personInfoDomainList, request.personBasicInfoRequest().deceasedDisplayType(), weddingDateDomain,
                weddingPlaceDomain);
        return invitationPersistence.saveInvitation(invitationDomain);
    }
}
