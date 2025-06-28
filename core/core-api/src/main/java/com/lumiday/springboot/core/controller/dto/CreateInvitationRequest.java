package com.lumiday.springboot.core.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CreateInvitationRequest(
        @NotNull String userId,
        @NotNull ThemeRequest theme
) {
}
