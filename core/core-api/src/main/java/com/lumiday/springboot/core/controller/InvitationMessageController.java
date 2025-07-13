package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.InvitationMessageResponse;
import com.lumiday.springboot.core.service.InvitationMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class InvitationMessageController {

    private final InvitationMessageService invitationMessageService;

    @GetMapping("/{invitationId}/message")
    public ResponseEntity<InvitationMessageResponse> getInvitationMessage(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationMessageService.getInvitationMessageByInvitationId(invitationId));
    }
}
