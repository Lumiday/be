package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.DeceasedDisplayType;
import java.util.List;

public record PersonBasicInfoResponse(
        List<PersonInfoResponse> personInfoList,
        DeceasedDisplayType deceasedDisplayType
) {
    public static PersonBasicInfoResponse of(List<PersonInfoResponse> personInfoList,
                                             DeceasedDisplayType deceasedDisplayType) {
        return new PersonBasicInfoResponse(personInfoList, deceasedDisplayType);
    }
}
