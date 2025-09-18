package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.jpa.vo.ThemeStyle;
import com.lumiday.springboot.core.domain.invitation.vo.ThemeDomain;
import com.lumiday.springboot.core.mapper.ThemeEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ThemePersistence {

    private final InvitationRepository invitationRepository;

    @Transactional(readOnly = true)
    public ThemeDomain getThemeByInvitationId(String invitationId) {
        InvitationEntity invitationEntity = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));

        ThemeStyle themeEntity = invitationEntity.getTheme();

        if (themeEntity == null) {
            throw new EntityNotFoundException("청첩장에 대한 테마를 찾을 수 없습니다.");
        }

        return ThemeEntityMapper.toDomain(themeEntity);
    }
}
