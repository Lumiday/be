package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.IntroLayoutEntity;
import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.IntroLayoutRepository;
import com.lumiday.springboot.core.domain.IntroLayoutDomain;
import com.lumiday.springboot.core.mapper.IntroLayoutEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class IntroLayoutPersistence {

    private final IntroLayoutRepository introLayoutRepository;

    public void saveIntroLayout(InvitationEntity invitationEntity, IntroLayoutDomain introLayoutDomain) {
        IntroLayoutEntity introLayoutEntity = IntroLayoutEntityMapper.toEntity(invitationEntity, introLayoutDomain);
        introLayoutRepository.save(introLayoutEntity);
    }

    @Transactional(readOnly = true)
    public IntroLayoutDomain getIntroLayoutByInvitationId(String invitationId) {
        IntroLayoutEntity introLayoutEntity = introLayoutRepository.findByInvitationId(invitationId)
                .orElseThrow(() -> new RuntimeException("인트로 레이아웃을 찾을 수 없습니다."));

        return IntroLayoutEntityMapper.toDomain(introLayoutEntity);
    }
}
