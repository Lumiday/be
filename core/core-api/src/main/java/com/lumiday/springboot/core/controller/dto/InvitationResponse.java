package com.lumiday.springboot.core.controller.dto;

public record InvitationResponse(
        ThemeResponse theme,
        IntroLayOutResponse introLayout,
        PersonBasicInfoResponse personBasicInfo,
        WeddingDateResponse weddingDate,
        WeddingPlaceResponse weddingPlace,
        InvitationMessageResponse invitationMessage,
        BackgroundMusicResponse backgroundMusic,
        TransportationGuideResponse transportationGuide,
        AccountInfoResponse accountInfo,
        GalleryResponse gallery,
        AttendanceCheckResponse attendanceCheck,
        EndingResponse ending
) {
}
