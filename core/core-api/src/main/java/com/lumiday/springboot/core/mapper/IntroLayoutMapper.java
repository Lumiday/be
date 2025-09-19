package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.IntroLayout;
import com.lumiday.springboot.core.controller.dto.IntroLayOutResponse;
import com.lumiday.springboot.core.controller.dto.IntroLayoutRequest;
import com.lumiday.springboot.core.domain.invitation.vo.IntroLayoutDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IntroLayoutMapper {
    IntroLayoutMapper INSTANCE = Mappers.getMapper(IntroLayoutMapper.class);

    IntroLayout toEntity(IntroLayoutDomain introLayoutDomain);

    IntroLayoutDomain toDomain(IntroLayout introLayout);

    IntroLayoutDomain toDomain(IntroLayoutRequest introLayout);

    IntroLayOutResponse toResponse(IntroLayoutDomain introLayoutDomain);
}
