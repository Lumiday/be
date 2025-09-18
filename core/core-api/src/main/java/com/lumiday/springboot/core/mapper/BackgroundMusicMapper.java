package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.BackgroundMusic;
import com.lumiday.springboot.core.controller.dto.BackgroundMusicRequest;
import com.lumiday.springboot.core.domain.invitation.vo.BackgroundMusicDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BackgroundMusicMapper {

    BackgroundMusicMapper INSTANCE = Mappers.getMapper(BackgroundMusicMapper.class);

    BackgroundMusic toEntity(BackgroundMusicDomain domain);

    BackgroundMusicDomain toDomain(BackgroundMusic entity);

    BackgroundMusicDomain toDomain(BackgroundMusicRequest entity);
}
