package com.lumiday.springboot.core.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CreateInvitationRequest(
        @NotNull ThemeRequest theme,
        @NotNull IntroLayoutRequest introLayout
) {
}
