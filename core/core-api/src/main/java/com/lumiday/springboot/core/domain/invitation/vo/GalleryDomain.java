package com.lumiday.springboot.core.domain.invitation.vo;

import com.lumiday.core.enums.GalleryType;
import java.util.List;
import lombok.Getter;

@Getter
public class GalleryDomain {
    private String name;
    private GalleryType type;
    private Boolean usePopUpView;
    private List<String> images;

    public GalleryDomain(String name, GalleryType type, Boolean usePopUpView, List<String> images) {
        this.name = name;
        this.type = type;
        this.usePopUpView = usePopUpView;
        this.images = images;
    }
}
