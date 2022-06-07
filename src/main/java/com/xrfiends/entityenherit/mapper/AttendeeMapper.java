package com.xrfiends.entityenherit.mapper;

import com.xrfiends.entityenherit.domain.Attendee;
import com.xrfiends.entityenherit.domain.Base;
import com.xrfiends.entityenherit.dto.AttendeeDTO;
import com.xrfiends.entityenherit.dto.BaseDTO;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AttendeeMapper implements EntityMapper<AttendeeDTO, Attendee> {
    @BeforeMapping
    protected void generateId(AttendeeDTO d) {
        if(!StringUtils.hasLength(d.getId())) {
            d.setId(UUID.randomUUID().toString());
        }
    }
}
