package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.PersonBasicInfoResponse;
import com.lumiday.springboot.core.domain.invitation.vo.PersonBaseInfoDomain;
import com.lumiday.springboot.core.implement.persistence.PersonBaseInfoPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonInfoService {

    private final PersonBaseInfoPersistence personBaseInfoPersistence;

    public PersonBasicInfoResponse getPersonInfoListByInvitationId(String invitationId) {
        PersonBaseInfoDomain personBaseInfoDomain = personBaseInfoPersistence.getPersonInfoListByInvitationId(
                invitationId);

        return PersonBasicInfoResponse.of(personBaseInfoDomain);
    }
}
