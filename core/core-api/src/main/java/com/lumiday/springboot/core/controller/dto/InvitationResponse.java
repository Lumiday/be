package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.InvitationDomain;

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
    public static InvitationResponse of(InvitationDomain invitationDomain) {
        return new InvitationResponse(
                ThemeResponse.of(invitationDomain.getTheme()),
                IntroLayOutResponse.of(invitationDomain.getIntroLayout()),
                PersonBasicInfoResponse.of(invitationDomain.getPersonBaseInfo()),
                WeddingDateResponse.of(invitationDomain.getWeddingDate()),
                WeddingPlaceResponse.of(invitationDomain.getWeddingPlace()),
                InvitationMessageResponse.of(invitationDomain.getInvitationMessage()),
                BackgroundMusicResponse.of(invitationDomain.getBackgroundMusic()),
                TransportationGuideResponse.of(invitationDomain.getTransportationGuide()),
                AccountInfoResponse.of(invitationDomain.getAccountInfo()),
                GalleryResponse.of(invitationDomain.getGallery()),
                AttendanceCheckResponse.of(invitationDomain.getAttendanceCheck()),
                EndingResponse.of(invitationDomain.getEnding())
        );
    }
}
