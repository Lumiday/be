package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.controller.dto.PersonBasicInfoResponse;
import com.lumiday.springboot.core.controller.dto.PersonInfoResponse;
import com.lumiday.springboot.core.domain.InvitationDomain;
import com.lumiday.springboot.core.domain.PersonInfoDomain;
import com.lumiday.springboot.core.implement.persistence.InvitationPersistence;
import com.lumiday.springboot.core.implement.persistence.PersonInfoPersistence;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonInfoService {

    private final PersonInfoPersistence personInfoPersistence;
    private final InvitationPersistence invitationPersistence;

    public PersonBasicInfoResponse getPersonInfoListByInvitationId(String invitationId) {
        List<PersonInfoDomain> personInfoDomainList = personInfoPersistence.getPersonInfoListByInvitationId(
                invitationId);
        InvitationDomain invitationDomain = invitationPersistence.getInvitationById(invitationId);

        return PersonBasicInfoResponse.of(
                personInfoDomainList.stream().map(PersonInfoResponse::of).toList(),
                invitationDomain.getDeceasedDisplayType());
    }
}
