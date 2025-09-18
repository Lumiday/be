package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.jpa.vo.WeddingDate;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingDateDomain;
import com.lumiday.springboot.core.mapper.WeddingDateMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class WeddingDatePersistence {

    private final InvitationRepository invitationRepository;

    @Transactional(readOnly = true)
    public WeddingDateDomain getWeddingDateByInvitationId(String invitationId) {
        InvitationEntity invitationEntity = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));

        WeddingDate weddingDate = invitationEntity.getWeddingDate();

        if (weddingDate == null) {
            throw new EntityNotFoundException("청첩장에 대한 결혼 날짜를 찾을 수 없습니다.");
        }

        return WeddingDateMapper.INSTANCE.toDomain(weddingDate);
    }
}
