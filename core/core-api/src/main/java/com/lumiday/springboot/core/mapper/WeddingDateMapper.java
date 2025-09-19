package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.WeddingDate;
import com.lumiday.springboot.core.controller.dto.WeddingDateRequest;
import com.lumiday.springboot.core.controller.dto.WeddingDateResponse;
import com.lumiday.springboot.core.domain.invitation.vo.WeddingDateDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeddingDateMapper {
    WeddingDateMapper INSTANCE = Mappers.getMapper(WeddingDateMapper.class);

    WeddingDate toEntity(WeddingDateDomain domain);

    WeddingDateDomain toDomain(WeddingDate weddingDate);

    WeddingDateDomain toDomain(WeddingDateRequest weddingDate);

    WeddingDateResponse toResponse(WeddingDateDomain weddingDateDomain);
}
