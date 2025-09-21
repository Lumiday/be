package com.lumiday.springboot.core.service;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.vo.AccountInfo;
import com.lumiday.jpa.vo.AttendanceCheck;
import com.lumiday.jpa.vo.BackgroundMusic;
import com.lumiday.jpa.vo.Ending;
import com.lumiday.jpa.vo.Gallery;
import com.lumiday.jpa.vo.IntroLayout;
import com.lumiday.jpa.vo.InvitationMessage;
import com.lumiday.jpa.vo.PersonBasicInfo;
import com.lumiday.jpa.vo.ThemeStyle;
import com.lumiday.jpa.vo.TransportationGuide;
import com.lumiday.jpa.vo.WeddingDate;
import com.lumiday.jpa.vo.WeddingPlace;
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
import com.lumiday.springboot.core.controller.dto.PersonBasicInfoRequest;
import com.lumiday.springboot.core.controller.dto.PersonBasicInfoResponse;
import com.lumiday.springboot.core.controller.dto.ThemeRequest;
import com.lumiday.springboot.core.controller.dto.ThemeResponse;
import com.lumiday.springboot.core.controller.dto.TransportationGuideRequest;
import com.lumiday.springboot.core.controller.dto.TransportationGuideResponse;
import com.lumiday.springboot.core.controller.dto.WeddingDateRequest;
import com.lumiday.springboot.core.controller.dto.WeddingDateResponse;
import com.lumiday.springboot.core.controller.dto.WeddingPlaceRequest;
import com.lumiday.springboot.core.controller.dto.WeddingPlaceResponse;
import com.lumiday.springboot.core.domain.UserDomain;
import com.lumiday.springboot.core.domain.invitation.aggregate.InvitationDomain;
import com.lumiday.springboot.core.domain.invitation.vo.AccountInfoDomain;
import com.lumiday.springboot.core.domain.invitation.vo.AttendanceCheckDomain;
import com.lumiday.springboot.core.domain.invitation.vo.BackgroundMusicDomain;
import com.lumiday.springboot.core.domain.invitation.vo.EndingDomain;
import com.lumiday.springboot.core.domain.invitation.vo.GalleryDomain;
import com.lumiday.springboot.core.domain.invitation.vo.IntroLayoutDomain;
import com.lumiday.springboot.core.domain.invitation.vo.InvitationMessageDomain;
import com.lumiday.springboot.core.domain.invitation.vo.PersonBasicInfoDomain;
import com.lumiday.springboot.core.domain.invitation.vo.ThemeDomain;
import com.lumiday.springboot.core.domain.invitation.vo.TransportationGuideDomain;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingDateDomain;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingPlaceDomain;
import com.lumiday.springboot.core.implement.persistence.InvitationPersistence;
import com.lumiday.springboot.core.mapper.AccountInfoMapper;
import com.lumiday.springboot.core.mapper.AttendanceCheckMapper;
import com.lumiday.springboot.core.mapper.BackgroundMusicMapper;
import com.lumiday.springboot.core.mapper.EndingMapper;
import com.lumiday.springboot.core.mapper.GalleryMapper;
import com.lumiday.springboot.core.mapper.IntroLayoutMapper;
import com.lumiday.springboot.core.mapper.InvitationMapper;
import com.lumiday.springboot.core.mapper.InvitationMessageMapper;
import com.lumiday.springboot.core.mapper.PersonBasicInfoMapper;
import com.lumiday.springboot.core.mapper.ThemeMapper;
import com.lumiday.springboot.core.mapper.TransportationGuideMapper;
import com.lumiday.springboot.core.mapper.WeddingDateMapper;
import com.lumiday.springboot.core.mapper.WeddingPlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationPersistence invitationPersistence;

    // --- Invitation 생성 ---
    public String createInvitation(CreateInvitationRequest request) {
        UserDomain user = UserDomain.of();
        InvitationDomain invitationDomain = InvitationMapper.INSTANCE.toDomain(user, request);
        return invitationPersistence.saveInvitation(invitationDomain);
    }

    public InvitationResponse getInvitationBy(String invitationId) {
        InvitationEntity invitation = invitationPersistence.getInvitationById(invitationId);
        InvitationDomain invitationDomain = InvitationMapper.INSTANCE.toDomain(invitation);
        return InvitationMapper.INSTANCE.toResponse(invitationDomain);
    }

    // --- IntroLayout ---
    public IntroLayOutResponse getIntroLayoutByInvitationId(String invitationId) {
        IntroLayout introLayout = invitationPersistence.getIntroLayoutByInvitationId(invitationId);
        IntroLayoutDomain introLayoutDomain = IntroLayoutMapper.INSTANCE.toDomain(introLayout);
        return IntroLayoutMapper.INSTANCE.toResponse(introLayoutDomain);
    }

    public IntroLayOutResponse updateIntroLayoutByInvitationId(String invitationId, IntroLayoutRequest request) {
        IntroLayoutDomain introLayoutDomain = IntroLayoutMapper.INSTANCE.toDomain(request);
        IntroLayout introLayout = invitationPersistence.updateIntroLayout(invitationId, introLayoutDomain);
        introLayoutDomain = IntroLayoutMapper.INSTANCE.toDomain(introLayout);
        return IntroLayoutMapper.INSTANCE.toResponse(introLayoutDomain);
    }

    // --- InvitationMessage ---
    public InvitationMessageResponse getInvitationMessageByInvitationId(String invitationId) {
        InvitationMessage invitationMessage = invitationPersistence.getInvitationMessageByInvitationId(invitationId);
        InvitationMessageDomain invitationMessageDomain = InvitationMessageMapper.INSTANCE.toDomain(invitationMessage);
        return InvitationMessageMapper.INSTANCE.toResponse(invitationMessageDomain);
    }

    public InvitationMessageResponse updateInvitationMessageByInvitationId(String invitationId,
                                                                           InvitationMessageRequest request) {
        InvitationMessageDomain invitationMessageDomain = InvitationMessageMapper.INSTANCE.toDomain(request);
        InvitationMessage invitationMessage = invitationPersistence.updateInvitationMessage(invitationId,
                invitationMessageDomain);
        invitationMessageDomain = InvitationMessageMapper.INSTANCE.toDomain(invitationMessage);
        return InvitationMessageMapper.INSTANCE.toResponse(invitationMessageDomain);
    }

    // --- Theme ---
    public ThemeResponse getThemeByInvitationId(String invitationId) {
        ThemeStyle theme = invitationPersistence.getThemeByInvitationId(invitationId);
        ThemeDomain themeDomain = ThemeMapper.INSTANCE.toDomain(theme);
        return ThemeMapper.INSTANCE.toResponse(themeDomain);
    }

    public ThemeResponse updateThemeByInvitationId(String invitationId, ThemeRequest request) {
        ThemeDomain themeDomain = ThemeMapper.INSTANCE.toDomain(request);
        ThemeStyle theme = invitationPersistence.updateTheme(invitationId, themeDomain);
        themeDomain = ThemeMapper.INSTANCE.toDomain(theme);
        return ThemeMapper.INSTANCE.toResponse(themeDomain);
    }

    // --- PersonBaseInfo ---
    public PersonBasicInfoResponse getPersonInfoByInvitationId(String invitationId) {
        PersonBasicInfo personBasicInfo = invitationPersistence.getPersonInfoByInvitationId(invitationId);
        PersonBasicInfoDomain personBasicInfoDomain = PersonBasicInfoMapper.INSTANCE.toDomain(personBasicInfo);
        return PersonBasicInfoMapper.INSTANCE.toResponse(personBasicInfoDomain);
    }

    public PersonBasicInfoResponse updatePersonInfoByInvitationId(String invitationId, PersonBasicInfoRequest request) {
        PersonBasicInfoDomain personBasicInfoDomain = PersonBasicInfoMapper.INSTANCE.toDomain(request);
        PersonBasicInfo personBasicInfo = invitationPersistence.updatePersonInfo(invitationId, personBasicInfoDomain);
        personBasicInfoDomain = PersonBasicInfoMapper.INSTANCE.toDomain(personBasicInfo);
        return PersonBasicInfoMapper.INSTANCE.toResponse(personBasicInfoDomain);
    }

    // --- WeddingDate ---
    public WeddingDateResponse getWeddingDateByInvitationId(String invitationId) {
        WeddingDate weddingDate = invitationPersistence.getWeddingDateByInvitationId(invitationId);
        WeddingDateDomain weddingDateDomain = WeddingDateMapper.INSTANCE.toDomain(weddingDate);
        return WeddingDateMapper.INSTANCE.toResponse(weddingDateDomain);
    }

    public WeddingDateResponse updateWeddingDateByInvitationId(String invitationId, WeddingDateRequest request) {
        WeddingDateDomain weddingDateDomain = WeddingDateMapper.INSTANCE.toDomain(request);
        WeddingDate weddingDate = invitationPersistence.updateWeddingDate(invitationId, weddingDateDomain);
        weddingDateDomain = WeddingDateMapper.INSTANCE.toDomain(weddingDate);
        return WeddingDateMapper.INSTANCE.toResponse(weddingDateDomain);
    }

    // --- WeddingPlace ---
    public WeddingPlaceResponse getWeddingPlaceByInvitationId(String invitationId) {
        WeddingPlace weddingPlace = invitationPersistence.getWeddingPlaceByInvitationId(invitationId);
        WeddingPlaceDomain weddingPlaceDomain = WeddingPlaceMapper.INSTANCE.toDomain(weddingPlace);
        return WeddingPlaceMapper.INSTANCE.toResponse(weddingPlaceDomain);
    }

    public WeddingPlaceResponse updateWeddingPlaceByInvitationId(String invitationId, WeddingPlaceRequest request) {
        WeddingPlaceDomain weddingPlaceDomain = WeddingPlaceMapper.INSTANCE.toDomain(request);
        WeddingPlace weddingPlace = invitationPersistence.updateWeddingPlace(invitationId, weddingPlaceDomain);
        weddingPlaceDomain = WeddingPlaceMapper.INSTANCE.toDomain(weddingPlace);
        return WeddingPlaceMapper.INSTANCE.toResponse(weddingPlaceDomain);
    }

    // --- AccountInfo ---
    public AccountInfoResponse getAccountInfoByInvitationId(String invitationId) {
        AccountInfo accountInfo = invitationPersistence.getAccountInfoByInvitationId(invitationId);
        AccountInfoDomain accountInfoDomain = AccountInfoMapper.INSTANCE.toDomain(accountInfo);
        return AccountInfoMapper.INSTANCE.toResponse(accountInfoDomain);
    }

    public AccountInfoResponse updateAccountInfoByInvitationId(String invitationId, AccountInfoRequest request) {
        AccountInfoDomain accountInfoDomain = AccountInfoMapper.INSTANCE.toDomain(request);
        AccountInfo accountInfo = invitationPersistence.updateAccountInfo(invitationId, accountInfoDomain);
        accountInfoDomain = AccountInfoMapper.INSTANCE.toDomain(accountInfo);
        return AccountInfoMapper.INSTANCE.toResponse(accountInfoDomain);
    }

    // --- AttendanceCheck ---
    public AttendanceCheckResponse getAttendanceCheckByInvitationId(String invitationId) {
        AttendanceCheck attendanceCheck = invitationPersistence.getAttendanceCheckByInvitationId(
                invitationId);
        AttendanceCheckDomain attendanceCheckDomain = AttendanceCheckMapper.INSTANCE.toDomain(attendanceCheck);
        return AttendanceCheckMapper.INSTANCE.toResponse(attendanceCheckDomain);
    }

    public AttendanceCheckResponse updateAttendanceCheckByInvitationId(String invitationId,
                                                                       AttendanceCheckRequest request) {
        AttendanceCheckDomain attendanceCheckDomain = AttendanceCheckMapper.INSTANCE.toDomain(request);
        AttendanceCheck attendanceCheck = invitationPersistence.updateAttendanceCheck(invitationId,
                attendanceCheckDomain);
        attendanceCheckDomain = AttendanceCheckMapper.INSTANCE.toDomain(attendanceCheck);
        return AttendanceCheckMapper.INSTANCE.toResponse(attendanceCheckDomain);
    }

    // --- BackgroundMusic ---
    public BackgroundMusicResponse getBackgroundMusicByInvitationId(String invitationId) {
        BackgroundMusic backgroundMusic = invitationPersistence.getBackgroundMusicByInvitationId(
                invitationId);
        BackgroundMusicDomain backgroundMusicDomain = BackgroundMusicMapper.INSTANCE.toDomain(backgroundMusic);
        return BackgroundMusicMapper.INSTANCE.toResponse(backgroundMusicDomain);
    }

    public BackgroundMusicResponse updateBackgroundMusicByInvitationId(String invitationId,
                                                                       BackgroundMusicRequest request) {
        BackgroundMusicDomain backgroundMusicDomain = BackgroundMusicMapper.INSTANCE.toDomain(request);
        BackgroundMusic backgroundMusic = invitationPersistence.updateBackgroundMusic(invitationId,
                backgroundMusicDomain);
        backgroundMusicDomain = BackgroundMusicMapper.INSTANCE.toDomain(backgroundMusic);
        return BackgroundMusicMapper.INSTANCE.toResponse(backgroundMusicDomain);
    }

    // --- Ending ---
    public EndingResponse getEndingByInvitationId(String invitationId) {
        Ending ending = invitationPersistence.getEndingByInvitationId(invitationId);
        EndingDomain endingDomain = EndingMapper.INSTANCE.toDomain(ending);
        return EndingMapper.INSTANCE.toResponse(endingDomain);
    }

    public EndingResponse updateEndingByInvitationId(String invitationId, EndingRequest request) {
        EndingDomain endingDomain = EndingMapper.INSTANCE.toDomain(request);
        Ending ending = invitationPersistence.updateEnding(invitationId, endingDomain);
        endingDomain = EndingMapper.INSTANCE.toDomain(ending);
        return EndingMapper.INSTANCE.toResponse(endingDomain);
    }

    // --- Gallery ---
    public GalleryResponse getGalleryByInvitationId(String invitationId) {
        Gallery gallery = invitationPersistence.getGalleryByInvitationId(invitationId);
        GalleryDomain galleryDomain = GalleryMapper.INSTANCE.toDomain(gallery);
        return GalleryMapper.INSTANCE.toResponse(galleryDomain);
    }

    public GalleryResponse updateGalleryByInvitationId(String invitationId, GalleryRequest request) {
        GalleryDomain galleryDomain = GalleryMapper.INSTANCE.toDomain(request);
        Gallery gallery = invitationPersistence.updateGallery(invitationId, galleryDomain);
        galleryDomain = GalleryMapper.INSTANCE.toDomain(gallery);
        return GalleryMapper.INSTANCE.toResponse(galleryDomain);
    }

    // --- TransportationGuide ---
    public TransportationGuideResponse getTransportationGuideByInvitationId(String invitationId) {
        TransportationGuide transportationGuide = invitationPersistence.getTransportationGuideByInvitationId(
                invitationId);
        TransportationGuideDomain transportationGuideDomain = TransportationGuideMapper.INSTANCE.toDomain(
                transportationGuide);
        return TransportationGuideMapper.INSTANCE.toResponse(transportationGuideDomain);
    }

    public TransportationGuideResponse updateTransportationGuideByInvitationId(String invitationId,
                                                                               TransportationGuideRequest request) {
        TransportationGuideDomain transportationGuideDomain = TransportationGuideMapper.INSTANCE.toDomain(request);
        TransportationGuide transportationGuide = invitationPersistence.updateTransportationGuide(invitationId,
                transportationGuideDomain);
        transportationGuideDomain = TransportationGuideMapper.INSTANCE.toDomain(transportationGuide);
        return TransportationGuideMapper.INSTANCE.toResponse(transportationGuideDomain);
    }
}
