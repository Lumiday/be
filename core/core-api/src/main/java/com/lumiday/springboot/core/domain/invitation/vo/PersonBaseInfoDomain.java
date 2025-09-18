package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.DeceasedDisplayType;
import com.lumiday.springboot.core.controller.dto.PersonBasicInfoRequest;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonBaseInfoDomain {
    private DeceasedDisplayType deceasedDisplayType;
    private List<PersonInfoDomain> personInfoList;

    public static PersonBaseInfoDomain of(DeceasedDisplayType deceasedDisplayType,
                                          List<PersonInfoDomain> personInfoList) {
        return new PersonBaseInfoDomain(deceasedDisplayType, personInfoList);
    }

    public static PersonBaseInfoDomain of(PersonBasicInfoRequest personBasicInfoRequest) {
        return new PersonBaseInfoDomain(
                personBasicInfoRequest.deceasedDisplayType(),
                personBasicInfoRequest.personInfoList().stream()
                        .map(PersonInfoDomain::of)
                        .toList()
        );
    }
}
