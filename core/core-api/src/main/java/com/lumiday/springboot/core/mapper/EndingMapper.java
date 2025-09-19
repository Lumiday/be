package com.lumiday.springboot.core.mapper;

import com.lumiday.jpa.vo.Ending;
import com.lumiday.springboot.core.controller.dto.EndingRequest;
import com.lumiday.springboot.core.controller.dto.EndingResponse;
import com.lumiday.springboot.core.domain.invitation.vo.EndingDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EndingMapper {

    EndingMapper INSTANCE = Mappers.getMapper(EndingMapper.class);

    Ending toEntity(EndingDomain domain);

    EndingDomain toDomain(Ending entity);

    EndingDomain toDomain(EndingRequest entity);

    EndingResponse toResponse(EndingDomain domain);
}
