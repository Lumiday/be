package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.ThemeStyle;
import com.lumiday.springboot.core.controller.dto.ThemeRequest;
import com.lumiday.springboot.core.domain.invitation.vo.ThemeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThemeMapper {
    ThemeMapper INSTANCE = Mappers.getMapper(ThemeMapper.class);

    ThemeStyle toEntity(ThemeDomain domain);

    ThemeDomain toDomain(ThemeStyle themeEntity);

    ThemeDomain toDomain(ThemeRequest themeEntity);
}
