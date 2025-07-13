package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.WeddingPlaceResponse;
import com.lumiday.springboot.core.service.WeddingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class WeddingPlaceController {

    private final WeddingPlaceService weddingPlaceService;

    @GetMapping("/{invitationId}/wedding-place")
    public ResponseEntity<WeddingPlaceResponse> getPersonInfo(@PathVariable String invitationId) {
        WeddingPlaceResponse weddingPlaceResponse = weddingPlaceService.getWeddingPlaceByInvitationId(invitationId);
        return ResponseEntity.ok(weddingPlaceResponse);
    }
}
