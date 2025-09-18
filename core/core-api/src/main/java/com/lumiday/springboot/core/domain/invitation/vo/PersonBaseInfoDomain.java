package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.DeceasedDisplayType;
import java.util.List;
import lombok.Getter;

@Getter
public class PersonBaseInfoDomain {
    private DeceasedDisplayType deceasedDisplayType;
    private List<PersonInfoDomain> personInfoList;

    public PersonBaseInfoDomain(DeceasedDisplayType deceasedDisplayType, List<PersonInfoDomain> personInfoList) {
        this.deceasedDisplayType = deceasedDisplayType;
        this.personInfoList = personInfoList;
    }
}
