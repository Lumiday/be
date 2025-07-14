package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.DeceasedDisplayType;
import com.lumiday.springboot.core.domain.PersonBaseInfoDomain;
import java.util.List;

public record PersonBasicInfoResponse(
        List<PersonInfoResponse> personInfoList,
        DeceasedDisplayType deceasedDisplayType
) {
    public static PersonBasicInfoResponse of(PersonBaseInfoDomain domain) {
        return new PersonBasicInfoResponse(
                domain.getPersonInfoList().stream()
                        .map(PersonInfoResponse::of)
                        .toList(),
                domain.getDeceasedDisplayType()
        );
    }
}
