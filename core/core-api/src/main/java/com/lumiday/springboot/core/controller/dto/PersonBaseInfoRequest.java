package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.DeceasedDisplayType;
import java.util.List;

public record PersonBaseInfoRequest(
        List<PersonInfoRequest> personInfoList,
        DeceasedDisplayType deceasedDisplayType
) {
}
