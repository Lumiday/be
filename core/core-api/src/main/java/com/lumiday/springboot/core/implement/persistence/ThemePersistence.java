package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.ThemeStyleEntity;
import com.lumiday.jpa.repository.ThemeRepository;
import com.lumiday.springboot.core.domain.ThemeDomain;
import com.lumiday.springboot.core.mapper.ThemeEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ThemePersistence {

    private final ThemeRepository themeRepository;

    @Transactional
    public void saveTheme(InvitationEntity invitationEntity, ThemeDomain themeDomain) {
        ThemeStyleEntity themeStyleEntity = ThemeEntityMapper.toEntity(invitationEntity, themeDomain);
        themeRepository.save(themeStyleEntity);
    }

    @Transactional(readOnly = true)
    public ThemeDomain getThemeByInvitationId(String invitationId) {
        ThemeStyleEntity themeEntity = themeRepository.findByInvitationId(invitationId)
                .orElseThrow(() -> new RuntimeException("테마를 찾을 수 없습니다."));

        return ThemeEntityMapper.toDomain(themeEntity);
    }
}
