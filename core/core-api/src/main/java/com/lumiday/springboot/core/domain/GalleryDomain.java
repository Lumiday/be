package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.GalleryType;
import com.lumiday.springboot.core.controller.dto.GalleryRequest;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GalleryDomain {
    private String name;
    private GalleryType type;
    private Boolean usePopUpView;
    private List<String> images;

    public static GalleryDomain of(GalleryRequest request) {
        return new GalleryDomain(
                request.name(),
                request.type(),
                request.usePopUpView(),
                request.images()
        );
    }

    public static GalleryDomain of(String name, GalleryType type, Boolean usePopUpView, List<String> images) {
        return new GalleryDomain(name, type, usePopUpView, images);
    }
}
