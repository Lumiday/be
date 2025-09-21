package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.DeceasedDisplayType;
import java.util.List;

public record PersonBasicInfoResponse(
        List<PersonInfoResponse> personInfos,
        DeceasedDisplayType deceasedDisplayType
) {
}
