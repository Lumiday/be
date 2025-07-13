package com.lumiday.springboot.core.implement.persistence;

import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.PersonInfoEntity;
import com.lumiday.jpa.repository.PersonInfoRepository;
import com.lumiday.springboot.core.domain.PersonInfoDomain;
import com.lumiday.springboot.core.mapper.PersonInfoEntityMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PersonInfoPersistence {

    private final PersonInfoRepository personInfoRepository;

    @Transactional
    public void savePersonInfoList(InvitationEntity invitationEntity, List<PersonInfoDomain> personInfoList) {
        List<PersonInfoEntity> personInfoEntityList = personInfoList.stream()
                .map(personInfoDomain -> PersonInfoEntityMapper.toEntity(invitationEntity, personInfoDomain)).toList();
        personInfoRepository.saveAll(personInfoEntityList);
    }

    @Transactional(readOnly = true)
    public List<PersonInfoDomain> getPersonInfoListByInvitationId(String invitationId) {
        List<PersonInfoEntity> personInfoEntityList = personInfoRepository.findAllByInvitationId(invitationId);

        return personInfoEntityList.stream()
                .map(PersonInfoEntityMapper::toDomain)
                .toList();
    }
}
