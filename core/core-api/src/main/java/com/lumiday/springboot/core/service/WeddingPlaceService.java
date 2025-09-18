package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.WeddingPlaceResponse;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingPlaceDomain;
import com.lumiday.springboot.core.implement.persistence.WeddingPlacePersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeddingPlaceService {

    private final WeddingPlacePersistence weddingPlacePersistence;

    public WeddingPlaceResponse getWeddingPlaceByInvitationId(String invitationId) {
        WeddingPlaceDomain weddingPlaceDomain = weddingPlacePersistence.getWeddingPlaceByInvitationId(invitationId);
        return WeddingPlaceResponse.of(weddingPlaceDomain);
    }
}
