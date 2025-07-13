package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.WeddingDateResponse;
import com.lumiday.springboot.core.domain.WeddingDateDomain;
import com.lumiday.springboot.core.implement.persistence.WeddingDatePersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeddingDateService {

    private final WeddingDatePersistence weddingdatePersistence;
    
    public WeddingDateResponse getWeddingDateByInvitationId(String invitationId) {
        WeddingDateDomain weddingDateDomain = weddingdatePersistence.getWeddingDateByInvitationId(invitationId);
        return WeddingDateResponse.of(weddingDateDomain);
    }
}
