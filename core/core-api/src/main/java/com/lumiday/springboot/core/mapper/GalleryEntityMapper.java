package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.GalleryEntity;
import com.lumiday.springboot.core.domain.GalleryDomain;

public class GalleryEntityMapper {

    private GalleryEntityMapper() {
    }

    public static GalleryEntity toEntity(GalleryDomain domain) {
        return GalleryEntity.of(
                domain.getName(),
                domain.getType(),
                domain.getUsePopUpView(),
                domain.getImages()
        );
    }

    public static GalleryDomain toDomain(GalleryEntity entity) {
        return GalleryDomain.of(
                entity.getName(),
                entity.getType(),
                entity.getUsePopUpView(),
                entity.getImages()
        );
    }
}
