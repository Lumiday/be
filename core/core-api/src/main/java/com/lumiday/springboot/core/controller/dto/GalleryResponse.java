package com.lumiday.springboot.core.controller.dto;

import com.lumiday.core.enums.GalleryType;
import com.lumiday.springboot.core.domain.invitation.vo.GalleryDomain;
import java.util.List;

public record GalleryResponse(
        String name,
        GalleryType type,
        Boolean usePopUpView,
        List<String> images
) {
    public static GalleryResponse of(GalleryDomain gallery) {
        return new GalleryResponse(
                gallery.getName(),
                gallery.getType(),
                gallery.getUsePopUpView(),
                gallery.getImages()
        );
    }
}
