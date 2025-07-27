package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.GalleryType;
import java.util.List;

public record GalleryRequest(
        String name,
        GalleryType type,
        Boolean usePopUpView,
        List<String> images
) {
}
