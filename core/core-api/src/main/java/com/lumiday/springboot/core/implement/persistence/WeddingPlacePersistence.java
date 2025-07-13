package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.WeddingPlaceEntity;
import com.lumiday.jpa.repository.WeddingPlaceRepository;
import com.lumiday.springboot.core.domain.WeddingPlaceDomain;
import com.lumiday.springboot.core.mapper.WeddingPlaceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class WeddingPlacePersistence {

    private final WeddingPlaceRepository weddingPlaceRepository;

    @Transactional
    public void saveWeddingPlace(InvitationEntity invitationEntity, WeddingPlaceDomain weddingPlaceDomain) {
        WeddingPlaceEntity weddingDateEntity = WeddingPlaceEntityMapper.toEntity(invitationEntity, weddingPlaceDomain);
        weddingPlaceRepository.save(weddingDateEntity);
    }

    @Transactional(readOnly = true)
    public WeddingPlaceDomain getWeddingPlaceByInvitationId(String invitationId) {
        WeddingPlaceEntity weddingPlaceEntity = weddingPlaceRepository.findByInvitationId(invitationId)
                .orElseThrow(() -> new RuntimeException("결혼 날짜를 찾을 수 없습니다."));

        return WeddingPlaceEntityMapper.toDomain(weddingPlaceEntity);
    }
}
