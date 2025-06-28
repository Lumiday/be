package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.service.InvitationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class InvitationController {
    private final InvitationService invitationService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CreateInvitationRequest createInvitationRequest) {
        String invitationId = invitationService.createInvitation(createInvitationRequest);
        return ResponseEntity.ok(invitationId);
    }
}
