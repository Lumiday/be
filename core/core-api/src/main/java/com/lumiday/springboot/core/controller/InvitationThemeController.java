package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.ThemeResponse;
import com.lumiday.springboot.core.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class InvitationThemeController {

    private final ThemeService themeService;

    @GetMapping("/{invitationId}/theme")
    public ResponseEntity<ThemeResponse> getInvitationTheme(@PathVariable String invitationId) {
        return ResponseEntity.ok(themeService.getThemeByInvitationId(invitationId));
    }
}
