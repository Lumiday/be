package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.repository.InvitationRepository;
import com.lumiday.jpa.vo.PersonBaseInfo;
import com.lumiday.springboot.core.domain.invitation.vo.PersonBaseInfoDomain;
import com.lumiday.springboot.core.mapper.PersonBaseInfoMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PersonBaseInfoPersistence {

    private final InvitationRepository invitationRepository;

    @Transactional(readOnly = true)
    public PersonBaseInfoDomain getPersonInfoListByInvitationId(String invitationId) {
        InvitationEntity invitationEntity = invitationRepository.findById(invitationId)
                .orElseThrow(() -> new EntityNotFoundException("청첩장을 찾을 수 없습니다."));

        PersonBaseInfo personBaseInfo = invitationEntity.getPersonBaseInfo();

        if (personBaseInfo == null) {
            throw new EntityNotFoundException("청첩장에 대한 인물 정보를 찾을 수 없습니다.");
        }

        return PersonBaseInfoMapper.INSTANCE.toDomain(personBaseInfo);
    }
}
