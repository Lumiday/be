package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.jpa.vo.WeddingPlace;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingPlaceDomain;
import com.lumiday.springboot.core.mapper.WeddingPlaceEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class WeddingPlacePersistence {

    private final InvitationRepository invitationRepository;

    @Transactional(readOnly = true)
    public WeddingPlaceDomain getWeddingPlaceByInvitationId(String invitationId) {
        InvitationEntity invitationEntity = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));

        WeddingPlace weddingPlace = invitationEntity.getWeddingPlace();

        if (weddingPlace == null) {
            throw new EntityNotFoundException("청첩장에 대한 결혼 장소를 찾을 수 없습니다.");
        }

        return WeddingPlaceEntityMapper.toDomain(weddingPlace);
    }
}
