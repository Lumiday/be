package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.Gallery;
import com.lumiday.springboot.core.controller.dto.GalleryRequest;
import com.lumiday.springboot.core.domain.invitation.vo.GalleryDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GalleryMapper {

    GalleryMapper INSTANCE = Mappers.getMapper(GalleryMapper.class);

    Gallery toEntity(GalleryDomain domain);

    GalleryDomain toDomain(Gallery entity);

    GalleryDomain toDomain(GalleryRequest entity);
}
