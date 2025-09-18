package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.springboot.core.domain.UserDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    UserEntity toEntity(UserDomain domain);

    UserDomain toDomain(UserEntity entity);
}
