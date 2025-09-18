package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.jpa.vo.InvitationMessage;
import com.lumiday.springboot.core.domain.invitation.vo.InvitationMessageDomain;
import com.lumiday.springboot.core.mapper.InvitationMessageEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InvitationMessagePersistence {

    private final InvitationRepository invitationRepository;

    @Transactional(readOnly = true)
    public InvitationMessageDomain getInvitationMessageByInvitationId(String invitationId) {
        InvitationEntity invitationEntity = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));

        InvitationMessage invitationMessage = invitationEntity.getInvitationMessage();

        if (invitationMessage == null) {
            throw new EntityNotFoundException("청첩장에 대한 초대 문구를 찾을 수 없습니다.");
        }

        return InvitationMessageEntityMapper.toDomain(invitationMessage);
    }
}
