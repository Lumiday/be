package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.springboot.core.domain.InvitationDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InvitationPersistence {

    private final ThemePersistence themePersistence;
    private final IntroLayoutPersistence introLayoutPersistence;
    private final UserPersistence userPersistence;

    private final InvitationRepository invitationRepository;

    @Transactional
    public String saveInvitation(InvitationDomain invitationDomain) {
        UserEntity userEntity = userPersistence.mapToEntity(invitationDomain.getUser());
        InvitationEntity invitationEntity = InvitationEntity.of(userEntity);

        invitationRepository.save(invitationEntity);
        introLayoutPersistence.saveIntroLayout(invitationEntity, invitationDomain.getIntroLayout());
        themePersistence.saveTheme(invitationEntity, invitationDomain.getTheme());

        return invitationEntity.getId();
    }
}
