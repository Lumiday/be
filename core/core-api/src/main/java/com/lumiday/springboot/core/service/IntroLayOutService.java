package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.IntroLayOutResponse;
import com.lumiday.springboot.core.domain.invitation.vo.IntroLayoutDomain;
import com.lumiday.springboot.core.implement.persistence.IntroLayoutPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntroLayOutService {
    private final IntroLayoutPersistence introLayoutPersistence;

    public IntroLayOutResponse getIntroLayoutByInvitationId(String invitationId) {
        IntroLayoutDomain introLayout = introLayoutPersistence.getIntroLayoutByInvitationId(invitationId);
        return IntroLayOutResponse.of(introLayout);
    }
}
