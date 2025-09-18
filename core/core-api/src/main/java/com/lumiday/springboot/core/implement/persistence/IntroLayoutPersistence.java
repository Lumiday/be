package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.jpa.vo.IntroLayout;
import com.lumiday.springboot.core.domain.invitation.vo.IntroLayoutDomain;
import com.lumiday.springboot.core.mapper.IntroLayoutEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class IntroLayoutPersistence {

    private final InvitationRepository invitationRepository;

    @Transactional
    public void updateIntroLayout(String invitationId, IntroLayoutDomain introLayoutDomain) {
        InvitationEntity invitation = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("초대장을 찾을 수 없습니다."));

        IntroLayout introLayout = invitation.getIntroLayout();
//        introLayout.update(introLayoutDomain.getLayoutType(), introLayoutDomain.getPhotoFrameStyle(),
//                introLayoutDomain.getImageName());
    }

    @Transactional(readOnly = true)
    public IntroLayoutDomain getIntroLayoutByInvitationId(String invitationId) {
        InvitationEntity invitationEntity = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));

        IntroLayout introLayout = invitationEntity.getIntroLayout();

        if (introLayout == null) {
            throw new EntityNotFoundException("청첩장에 대한 인트로 레이아웃을 찾을 수 없습니다.");
        }

        return IntroLayoutEntityMapper.toDomain(introLayout);
    }
}
