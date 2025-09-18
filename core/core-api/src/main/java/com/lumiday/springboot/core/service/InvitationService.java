package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.CreateInvitationRequest;
import com.lumiday.springboot.core.controller.dto.InvitationResponse;
import com.lumiday.springboot.core.domain.UserDomain;
import com.lumiday.springboot.core.domain.invitation.aggregate.InvitationDomain;
import com.lumiday.springboot.core.domain.invitation.vo.AccountInfoDomain;
import com.lumiday.springboot.core.domain.invitation.vo.AttendanceCheckDomain;
import com.lumiday.springboot.core.domain.invitation.vo.BackgroundMusicDomain;
import com.lumiday.springboot.core.domain.invitation.vo.EndingDomain;
import com.lumiday.springboot.core.domain.invitation.vo.GalleryDomain;
import com.lumiday.springboot.core.domain.invitation.vo.IntroLayoutDomain;
import com.lumiday.springboot.core.domain.invitation.vo.InvitationMessageDomain;
import com.lumiday.springboot.core.domain.invitation.vo.PersonBaseInfoDomain;
import com.lumiday.springboot.core.domain.invitation.vo.ThemeDomain;
import com.lumiday.springboot.core.domain.invitation.vo.TransportationGuideDomain;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingDateDomain;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingPlaceDomain;
import com.lumiday.springboot.core.implement.persistence.InvitationPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationPersistence invitationPersistence;

    public String createInvitation(CreateInvitationRequest request) {
        UserDomain user = UserDomain.of();

        ThemeDomain themeDomain = ThemeDomain.of(request.theme());
        IntroLayoutDomain introLayoutDomain = IntroLayoutDomain.of(request.introLayout());
        PersonBaseInfoDomain personBaseInfoDomain = PersonBaseInfoDomain.of(request.personBasicInfo());
        WeddingDateDomain weddingDateDomain = WeddingDateDomain.of(request.weddingDate());
        WeddingPlaceDomain weddingPlaceDomain = WeddingPlaceDomain.of(request.weddingPlace());
        InvitationMessageDomain invitationMessageDomain = InvitationMessageDomain.of(
                request.invitationMessage());
        BackgroundMusicDomain backgroundMusicDomain = BackgroundMusicDomain.of(request.backgroundMusic());
        TransportationGuideDomain transportationGuideDomain = TransportationGuideDomain.of(
                request.transportationGuide());
        AccountInfoDomain accountInfoDomain = AccountInfoDomain.of(request.accountInfo());
        GalleryDomain galleryDomain = GalleryDomain.of(request.gallery());
        AttendanceCheckDomain attendanceCheckDomain = AttendanceCheckDomain.of(request.attendanceCheck());
        EndingDomain endingDomain = EndingDomain.of(request.ending());

        InvitationDomain invitationDomain = InvitationDomain.builder()
                .user(user)
                .theme(themeDomain)
                .introLayout(introLayoutDomain)
                .personBaseInfo(personBaseInfoDomain)
                .weddingDate(weddingDateDomain)
                .weddingPlace(weddingPlaceDomain)
                .invitationMessage(invitationMessageDomain)
                .backgroundMusic(backgroundMusicDomain)
                .transportationGuide(transportationGuideDomain)
                .accountInfo(accountInfoDomain)
                .gallery(galleryDomain)
                .attendanceCheck(attendanceCheckDomain)
                .ending(endingDomain)
                .build();
        return invitationPersistence.saveInvitation(invitationDomain);
    }

    public InvitationResponse getInvitationBy(String invitationId) {
        InvitationDomain invitation = invitationPersistence.getInvitationById(invitationId);
        return InvitationResponse.of(invitation);
    }
}
