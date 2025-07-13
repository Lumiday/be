package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.InvitationMessageEntity;
import com.lumiday.jpa.repository.InvitationMessageRepository;
import com.lumiday.springboot.core.domain.InvitationMessageDomain;
import com.lumiday.springboot.core.mapper.InvitationMessageEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InvitationMessagePersistence {

    private final InvitationMessageRepository invitationMessageRepository;

    @Transactional
    public void saveInvitationMessage(InvitationEntity invitationEntity,
                                      InvitationMessageDomain invitationMessageDomain) {
        InvitationMessageEntity invitationMessageEntity = InvitationMessageEntityMapper.toEntity(invitationEntity,
                invitationMessageDomain);
        invitationMessageRepository.save(invitationMessageEntity);
    }

    @Transactional(readOnly = true)
    public InvitationMessageDomain getInvitationMessageByInvitationId(String invitationId) {
        InvitationMessageEntity invitationMessageEntity = invitationMessageRepository.findByInvitationId(invitationId)
                .orElseThrow(() -> new RuntimeException("테마를 찾을 수 없습니다."));

        return InvitationMessageEntityMapper.toDomain(invitationMessageEntity);
    }
}
