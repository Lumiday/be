package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.WeddingDateEntity;
import com.lumiday.jpa.repository.WeddingDateRepository;
import com.lumiday.springboot.core.domain.WeddingDateDomain;
import com.lumiday.springboot.core.mapper.WeddingDateEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class WeddingDatePersistence {

    private final WeddingDateRepository weddingDateRepository;

    @Transactional
    public void saveWeddingDate(InvitationEntity invitationEntity, WeddingDateDomain weddingDateDomain) {
        WeddingDateEntity weddingDateEntity = WeddingDateEntityMapper.toEntity(invitationEntity, weddingDateDomain);
        weddingDateRepository.save(weddingDateEntity);
    }

    @Transactional(readOnly = true)
    public WeddingDateDomain getWeddingDateByInvitationId(String invitationId) {
        WeddingDateEntity weddingDateEntity = weddingDateRepository.findByInvitationId(invitationId)
                .orElseThrow(() -> new RuntimeException("결혼 날짜를 찾을 수 없습니다."));

        return WeddingDateEntityMapper.toDomain(weddingDateEntity);
    }
}
