package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.GalleryType;
import java.util.List;

public record GalleryResponse(
        String name,
        GalleryType type,
        Boolean usePopUpView,
        List<String> images
) {
}
