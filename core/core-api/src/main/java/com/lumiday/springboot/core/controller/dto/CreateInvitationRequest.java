package com.lumiday.springboot.core.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CreateInvitationRequest(
        @NotNull ThemeRequest theme,
        @NotNull IntroLayoutRequest introLayout,
        @NotNull PersonBasicInfoRequest personBasicInfoRequest,
        @NotNull WeddingDateRequest weddingDateRequest,
        @NotNull WeddingPlaceRequest weddingPlaceRequest,
        @NotNull InvitationMessageRequest invitationMessageRequest
) {
}
