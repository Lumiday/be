package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.PhotoFrameStyle;
import jakarta.validation.constraints.NotNull;

public record IntroLayoutUpdateRequest(
        @NotNull String layoutType,
        @NotNull PhotoFrameStyle photoFrameStyle
) {
}
