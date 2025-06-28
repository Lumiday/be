package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.IntroLayoutEntity;
import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.IntroLayoutRepository;
import com.lumiday.springboot.core.domain.IntroLayoutDomain;
import com.lumiday.springboot.core.mapper.IntroLayoutEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntroLayoutPersistence {

    private final IntroLayoutRepository introLayoutRepository;

    public void saveIntroLayout(InvitationEntity invitationEntity, IntroLayoutDomain introLayoutDomain) {
        IntroLayoutEntity introLayoutEntity = IntroLayoutEntityMapper.toEntity(invitationEntity, introLayoutDomain);
        introLayoutRepository.save(introLayoutEntity);
    }
}
