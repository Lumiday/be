package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.springboot.core.domain.InvitationDomain;
import com.lumiday.springboot.core.mapper.InvitationEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InvitationPersistence {

    private final UserPersistence userPersistence;
    private final InvitationRepository invitationRepository;

    @Transactional
    public String saveInvitation(InvitationDomain invitationDomain) {
        UserEntity userEntity = userPersistence.mapToEntity(invitationDomain.getUser());
        InvitationEntity invitationEntity = InvitationEntityMapper.toEntity(userEntity, invitationDomain);

        invitationRepository.save(invitationEntity);
        return invitationEntity.getId();
    }

    @Transactional(readOnly = true)
    public InvitationDomain getInvitationById(String invitationId) {
        InvitationEntity invitationEntity = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));

        return InvitationEntityMapper.toDomain(invitationEntity);
    }
}
