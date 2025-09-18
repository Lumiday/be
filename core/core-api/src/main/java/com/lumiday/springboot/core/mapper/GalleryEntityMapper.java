package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.Gallery;
import com.lumiday.springboot.core.domain.invitation.vo.GalleryDomain;

public class GalleryEntityMapper {

    private GalleryEntityMapper() {
    }

    public static Gallery toEntity(GalleryDomain domain) {
        return Gallery.of(
                domain.getName(),
                domain.getType(),
                domain.getUsePopUpView(),
                domain.getImages()
        );
    }

    public static GalleryDomain toDomain(Gallery entity) {
        return GalleryDomain.of(
                entity.getName(),
                entity.getType(),
                entity.getUsePopUpView(),
                entity.getImages()
        );
    }
}
