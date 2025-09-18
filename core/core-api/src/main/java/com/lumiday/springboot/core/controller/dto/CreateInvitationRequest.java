package com.lumiday.springboot.core.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CreateInvitationRequest(
        @NotNull ThemeRequest theme,
        @NotNull IntroLayoutRequest introLayout,
        @NotNull PersonBaseInfoRequest personBaseInfo,
        @NotNull WeddingDateRequest weddingDate,
        @NotNull WeddingPlaceRequest weddingPlace,
        @NotNull InvitationMessageRequest invitationMessage,
        BackgroundMusicRequest backgroundMusic,
        TransportationGuideRequest transportationGuide,
        AccountInfoRequest accountInfo,
        GalleryRequest gallery,
        AttendanceCheckRequest attendanceCheck,
        EndingRequest ending
) {
}
