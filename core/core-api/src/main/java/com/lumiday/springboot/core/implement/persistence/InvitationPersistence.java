package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.jpa.repository.InvitationRepository;
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
import com.lumiday.springboot.core.exception.ResourceNotFoundException;
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
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InvitationPersistence {

    private final UserPersistence userPersistence;
    private final InvitationRepository invitationRepository;

    @Transactional
    public String saveInvitation(InvitationDomain invitationDomain) {
        UserEntity userEntity = userPersistence.mapToEntity(invitationDomain.getUser());
        InvitationEntity invitationEntity = InvitationMapper.INSTANCE.toEntity(userEntity, invitationDomain);
        invitationRepository.save(invitationEntity);
        return invitationEntity.getId();
    }

    @Transactional(readOnly = true)
    public InvitationEntity getInvitationById(String invitationId) {
        return getInvitationEntityOrThrow(invitationId);
    }

    // --- IntroLayout ---
    @Transactional
    public IntroLayout updateIntroLayout(String invitationId, IntroLayoutDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        IntroLayout entity = IntroLayoutMapper.INSTANCE.toEntity(domain);
        invitation.changeIntroLayout(entity);
        return requireNonNullOrThrow(invitation.getIntroLayout(), "청첩장에 대한 인트로 레이아웃을 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public IntroLayout getIntroLayoutByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getIntroLayout(), "청첩장에 대한 인트로 레이아웃을 찾을 수 없습니다.");
    }

    // --- InvitationMessage ---
    @Transactional
    public InvitationMessage updateInvitationMessage(String invitationId, InvitationMessageDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        InvitationMessage entity = InvitationMessageMapper.INSTANCE.toEntity(domain);
        invitation.changeInvitationMessage(entity);
        return requireNonNullOrThrow(invitation.getInvitationMessage(), "청첩장에 대한 초대 문구를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public InvitationMessage getInvitationMessageByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getInvitationMessage(), "청첩장에 대한 초대 문구를 찾을 수 없습니다.");
    }

    // --- PersonBaseInfo ---
    @Transactional
    public PersonBasicInfo updatePersonInfo(String invitationId, PersonBasicInfoDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        PersonBasicInfo personBasicInfo = PersonBasicInfoMapper.INSTANCE.toEntity(domain);
        invitation.changePersonBaseInfo(personBasicInfo);
        return requireNonNullOrThrow(invitation.getPersonBasicInfo(), "청첩장에 대한 인물 정보를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public PersonBasicInfo getPersonInfoByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getPersonBasicInfo(), "청첩장에 대한 인물 정보를 찾을 수 없습니다.");
    }

    // --- Theme ---
    @Transactional
    public ThemeStyle updateTheme(String invitationId, ThemeDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        ThemeStyle themeStyle = ThemeMapper.INSTANCE.toEntity(domain);
        invitation.changeTheme(themeStyle);
        return requireNonNullOrThrow(invitation.getTheme(), "청첩장에 대한 테마를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public ThemeStyle getThemeByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getTheme(), "청첩장에 대한 테마를 찾을 수 없습니다.");
    }

    // --- WeddingDate ---
    @Transactional
    public WeddingDate updateWeddingDate(String invitationId, WeddingDateDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        WeddingDate weddingDate = WeddingDateMapper.INSTANCE.toEntity(domain);
        invitation.changeWeddingDate(weddingDate);
        return requireNonNullOrThrow(invitation.getWeddingDate(), "청첩장에 대한 결혼 날짜를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public WeddingDate getWeddingDateByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getWeddingDate(), "청첩장에 대한 결혼 날짜를 찾을 수 없습니다.");
    }

    // --- WeddingPlace ---
    @Transactional
    public WeddingPlace updateWeddingPlace(String invitationId, WeddingPlaceDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        WeddingPlace weddingPlace = WeddingPlaceMapper.INSTANCE.toEntity(domain);
        invitation.changeWeddingPlace(weddingPlace);
        return requireNonNullOrThrow(invitation.getWeddingPlace(), "청첩장에 대한 결혼 장소를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public WeddingPlace getWeddingPlaceByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getWeddingPlace(), "청첩장에 대한 결혼 장소를 찾을 수 없습니다.");
    }

    // --- AccountInfo ---
    @Transactional
    public AccountInfo updateAccountInfo(String invitationId, AccountInfoDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        AccountInfo accountInfo = AccountInfoMapper.INSTANCE.toEntity(domain);
        invitation.changeAccountInfo(accountInfo);
        return requireNonNullOrThrow(invitation.getAccountInfo(), "청첩장에 대한 계좌 정보를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public AccountInfo getAccountInfoByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getAccountInfo(), "청첩장에 대한 계좌 정보를 찾을 수 없습니다.");
    }

    // --- AttendanceCheck ---
    @Transactional
    public AttendanceCheck updateAttendanceCheck(String invitationId, AttendanceCheckDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        AttendanceCheck attendanceCheck = AttendanceCheckMapper.INSTANCE.toEntity(domain);
        invitation.changeAttendanceCheck(attendanceCheck);
        return requireNonNullOrThrow(invitation.getAttendanceCheck(), "청첩장에 대한 참석 체크를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public AttendanceCheck getAttendanceCheckByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getAttendanceCheck(), "청첩장에 대한 참석 체크를 찾을 수 없습니다.");
    }

    // --- BackgroundMusic ---
    @Transactional
    public BackgroundMusic updateBackgroundMusic(String invitationId, BackgroundMusicDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        BackgroundMusic backgroundMusic = BackgroundMusicMapper.INSTANCE.toEntity(domain);
        invitation.changeBackgroundMusic(backgroundMusic);
        return requireNonNullOrThrow(invitation.getBackgroundMusic(), "청첩장에 대한 배경 음악을 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public BackgroundMusic getBackgroundMusicByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getBackgroundMusic(), "청첩장에 대한 배경 음악을 찾을 수 없습니다.");
    }

    // --- Ending ---
    @Transactional
    public Ending updateEnding(String invitationId, EndingDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        Ending ending = EndingMapper.INSTANCE.toEntity(domain);
        invitation.changeEnding(ending);
        return requireNonNullOrThrow(invitation.getEnding(), "청첩장에 대한 엔딩 정보를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public Ending getEndingByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getEnding(), "청첩장에 대한 엔딩 정보를 찾을 수 없습니다.");
    }

    // --- Gallery ---
    @Transactional
    public Gallery updateGallery(String invitationId, GalleryDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        Gallery gallery = GalleryMapper.INSTANCE.toEntity(domain);
        invitation.changeGallery(gallery);
        return requireNonNullOrThrow(invitation.getGallery(), "청첩장에 대한 갤러리를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public Gallery getGalleryByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getGallery(), "청첩장에 대한 갤러리를 찾을 수 없습니다.");
    }

    // --- TransportationGuide ---
    @Transactional
    public TransportationGuide updateTransportationGuide(String invitationId, TransportationGuideDomain domain) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        TransportationGuide transportationGuide = TransportationGuideMapper.INSTANCE.toEntity(domain);
        invitation.changeTransportationGuide(transportationGuide);
        return requireNonNullOrThrow(invitation.getTransportationGuide(), "청첩장에 대한 교통 정보를 찾을 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public TransportationGuide getTransportationGuideByInvitationId(String invitationId) {
        InvitationEntity invitation = getInvitationEntityOrThrow(invitationId);
        return requireNonNullOrThrow(invitation.getTransportationGuide(), "청첩장에 대한 교통 정보를 찾을 수 없습니다.");
    }

    private InvitationEntity getInvitationEntityOrThrow(String invitationId) {
        return invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));
    }

    private <T> T requireNonNullOrThrow(T obj, String message) {
        if (obj == null) {
            throw new ResourceNotFoundException(message);
        }
        return obj;
    }
}
