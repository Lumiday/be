package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.WeddingDateResponse;
import com.lumiday.springboot.core.service.WeddingDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class WeddingDateController {

    private final WeddingDateService weddingDateService;

    @GetMapping("/{invitationId}/wedding-date")
    public ResponseEntity<WeddingDateResponse> getPersonInfo(@PathVariable String invitationId) {
        WeddingDateResponse weddingDateResponse = weddingDateService.getWeddingDateByInvitationId(invitationId);
        return ResponseEntity.ok(weddingDateResponse);
    }
}
