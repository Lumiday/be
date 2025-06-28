package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.springboot.core.domain.ThemeDomain;
import com.lumiday.springboot.core.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InvitationPersistence {

    private final ThemePersistence themePersistence;
    private final InvitationRepository invitationRepository;
    private final UserPersistence userPersistence;

    @Transactional
    public String saveInvitation(UserDomain user, ThemeDomain themeDomain) {
        UserEntity userEntity = userPersistence.getUserEntityByDomain(user);
        InvitationEntity invitationEntity = InvitationEntity.of(userEntity);

        themePersistence.saveTheme(invitationEntity, themeDomain);
        invitationRepository.save(invitationEntity);

        return invitationEntity.getId();
    }
}
