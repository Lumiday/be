package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.ThemeResponse;
import com.lumiday.springboot.core.domain.invitation.vo.ThemeDomain;
import com.lumiday.springboot.core.implement.persistence.ThemePersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationThemeService {

    private final ThemePersistence themePersistence;


    public ThemeResponse getThemeByInvitationId(String invitationId) {
        ThemeDomain theme = themePersistence.getThemeByInvitationId(invitationId);
        return ThemeResponse.of(theme);
    }
}
