package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.IntroLayOutResponse;
import com.lumiday.springboot.core.service.IntroLayOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class IntroLayoutController {

    private final IntroLayOutService introLayOutService;

    @GetMapping("/{invitationId}/intro-layout")
    public ResponseEntity<IntroLayOutResponse> getInvitationIntroLayout(@PathVariable String invitationId) {
        return ResponseEntity.ok(introLayOutService.getIntroLayoutByInvitationId(invitationId));
    }
}
