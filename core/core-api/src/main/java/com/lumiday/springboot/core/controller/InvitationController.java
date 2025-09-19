package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.AccountInfoRequest;
import com.lumiday.springboot.core.controller.dto.AccountInfoResponse;
import com.lumiday.springboot.core.controller.dto.AttendanceCheckRequest;
import com.lumiday.springboot.core.controller.dto.AttendanceCheckResponse;
import com.lumiday.springboot.core.controller.dto.BackgroundMusicRequest;
import com.lumiday.springboot.core.controller.dto.BackgroundMusicResponse;
import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.controller.dto.EndingRequest;
import com.lumiday.springboot.core.controller.dto.EndingResponse;
import com.lumiday.springboot.core.controller.dto.GalleryRequest;
import com.lumiday.springboot.core.controller.dto.GalleryResponse;
import com.lumiday.springboot.core.controller.dto.IntroLayOutResponse;
import com.lumiday.springboot.core.controller.dto.IntroLayoutRequest;
import com.lumiday.springboot.core.controller.dto.InvitationMessageRequest;
import com.lumiday.springboot.core.controller.dto.InvitationMessageResponse;
import com.lumiday.springboot.core.controller.dto.InvitationResponse;
import com.lumiday.springboot.core.controller.dto.PersonBaseInfoRequest;
import com.lumiday.springboot.core.controller.dto.PersonBasicInfoResponse;
import com.lumiday.springboot.core.controller.dto.ThemeRequest;
import com.lumiday.springboot.core.controller.dto.ThemeResponse;
import com.lumiday.springboot.core.controller.dto.TransportationGuideRequest;
import com.lumiday.springboot.core.controller.dto.TransportationGuideResponse;
import com.lumiday.springboot.core.controller.dto.WeddingDateRequest;
import com.lumiday.springboot.core.controller.dto.WeddingDateResponse;
import com.lumiday.springboot.core.controller.dto.WeddingPlaceRequest;
import com.lumiday.springboot.core.controller.dto.WeddingPlaceResponse;
import com.lumiday.springboot.core.service.InvitationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class InvitationController {
    private final InvitationService invitationService;

    // --- Invitation ---
    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CreateInvitationRequest createInvitationRequest) {
        String invitationId = invitationService.createInvitation(createInvitationRequest);
        return ResponseEntity.ok(invitationId);
    }

    @GetMapping("/{invitationId}")
    public ResponseEntity<InvitationResponse> getInvitation(@PathVariable String invitationId) {
        InvitationResponse invitationResponse = invitationService.getInvitationBy(invitationId);
        return ResponseEntity.ok(invitationResponse);
    }

    // --- IntroLayout ---
    @GetMapping("/{invitationId}/intro-layout")
    public ResponseEntity<IntroLayOutResponse> getInvitationIntroLayout(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getIntroLayoutByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/intro-layout")
    public ResponseEntity<IntroLayOutResponse> updateInvitationIntroLayout(@PathVariable String invitationId,
                                                                           @RequestBody IntroLayoutRequest request) {
        return ResponseEntity.ok(invitationService.updateIntroLayoutByInvitationId(invitationId, request));
    }

    // --- InvitationMessage ---
    @GetMapping("/{invitationId}/message")
    public ResponseEntity<InvitationMessageResponse> getInvitationMessage(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getInvitationMessageByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/message")
    public ResponseEntity<InvitationMessageResponse> updateInvitationMessage(@PathVariable String invitationId,
                                                                             @RequestBody InvitationMessageRequest request) {
        return ResponseEntity.ok(invitationService.updateInvitationMessageByInvitationId(invitationId, request));
    }

    // --- Theme ---
    @GetMapping("/{invitationId}/theme")
    public ResponseEntity<ThemeResponse> getInvitationTheme(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getThemeByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/theme")
    public ResponseEntity<ThemeResponse> updateInvitationTheme(@PathVariable String invitationId,
                                                               @RequestBody ThemeRequest request) {
        return ResponseEntity.ok(invitationService.updateThemeByInvitationId(invitationId, request));
    }

    // --- PersonBaseInfo ---
    @GetMapping("/{invitationId}/person-info")
    public ResponseEntity<PersonBasicInfoResponse> getPersonInfo(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getPersonInfoByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/person-info")
    public ResponseEntity<PersonBasicInfoResponse> updatePersonInfo(@PathVariable String invitationId,
                                                                    @RequestBody PersonBaseInfoRequest request) {
        return ResponseEntity.ok(invitationService.updatePersonInfoByInvitationId(invitationId, request));
    }

    // --- WeddingDate ---
    @GetMapping("/{invitationId}/wedding-date")
    public ResponseEntity<WeddingDateResponse> getWeddingDate(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getWeddingDateByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/wedding-date")
    public ResponseEntity<WeddingDateResponse> updateWeddingDate(@PathVariable String invitationId,
                                                                 @RequestBody WeddingDateRequest request) {
        return ResponseEntity.ok(invitationService.updateWeddingDateByInvitationId(invitationId, request));
    }

    // --- WeddingPlace ---
    @GetMapping("/{invitationId}/wedding-place")
    public ResponseEntity<WeddingPlaceResponse> getWeddingPlace(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getWeddingPlaceByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/wedding-place")
    public ResponseEntity<WeddingPlaceResponse> updateWeddingPlace(@PathVariable String invitationId,
                                                                   @RequestBody WeddingPlaceRequest request) {
        return ResponseEntity.ok(invitationService.updateWeddingPlaceByInvitationId(invitationId, request));
    }

    // --- AccountInfo ---
    @GetMapping("/{invitationId}/account-info")
    public ResponseEntity<AccountInfoResponse> getAccountInfo(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getAccountInfoByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/account-info")
    public ResponseEntity<AccountInfoResponse> updateAccountInfo(@PathVariable String invitationId,
                                                                 @RequestBody AccountInfoRequest request) {
        return ResponseEntity.ok(invitationService.updateAccountInfoByInvitationId(invitationId, request));
    }

    // --- AttendanceCheck ---
    @GetMapping("/{invitationId}/attendance-check")
    public ResponseEntity<AttendanceCheckResponse> getAttendanceCheck(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getAttendanceCheckByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/attendance-check")
    public ResponseEntity<AttendanceCheckResponse> updateAttendanceCheck(@PathVariable String invitationId,
                                                                         @RequestBody AttendanceCheckRequest request) {
        return ResponseEntity.ok(invitationService.updateAttendanceCheckByInvitationId(invitationId, request));
    }

    // --- BackgroundMusic ---
    @GetMapping("/{invitationId}/background-music")
    public ResponseEntity<BackgroundMusicResponse> getBackgroundMusic(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getBackgroundMusicByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/background-music")
    public ResponseEntity<BackgroundMusicResponse> updateBackgroundMusic(@PathVariable String invitationId,
                                                                         @RequestBody BackgroundMusicRequest request) {
        return ResponseEntity.ok(invitationService.updateBackgroundMusicByInvitationId(invitationId, request));
    }

    // --- Ending ---
    @GetMapping("/{invitationId}/ending")
    public ResponseEntity<EndingResponse> getEnding(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getEndingByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/ending")
    public ResponseEntity<EndingResponse> updateEnding(@PathVariable String invitationId,
                                                       @RequestBody EndingRequest request) {
        return ResponseEntity.ok(invitationService.updateEndingByInvitationId(invitationId, request));
    }

    // --- Gallery ---
    @GetMapping("/{invitationId}/gallery")
    public ResponseEntity<GalleryResponse> getGallery(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getGalleryByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/gallery")
    public ResponseEntity<GalleryResponse> updateGallery(@PathVariable String invitationId,
                                                         @RequestBody GalleryRequest request) {
        return ResponseEntity.ok(invitationService.updateGalleryByInvitationId(invitationId, request));
    }

    // --- TransportationGuide ---
    @GetMapping("/{invitationId}/transportation-guide")
    public ResponseEntity<TransportationGuideResponse> getTransportationGuide(@PathVariable String invitationId) {
        return ResponseEntity.ok(invitationService.getTransportationGuideByInvitationId(invitationId));
    }

    @PatchMapping("/{invitationId}/transportation-guide")
    public ResponseEntity<TransportationGuideResponse> updateTransportationGuide(@PathVariable String invitationId,
                                                                                 @RequestBody TransportationGuideRequest request) {
        return ResponseEntity.ok(invitationService.updateTransportationGuideByInvitationId(invitationId, request));
    }
}
