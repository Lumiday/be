package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.DeceasedDisplayType;
import java.util.List;
import lombok.Getter;

@Getter
public class PersonBasicInfoDomain {
    private DeceasedDisplayType deceasedDisplayType;
    private List<PersonInfoDomain> personInfos;

    public PersonBasicInfoDomain(DeceasedDisplayType deceasedDisplayType, List<PersonInfoDomain> personInfos) {
        this.deceasedDisplayType = deceasedDisplayType;
        this.personInfos = personInfos;
    }
}
