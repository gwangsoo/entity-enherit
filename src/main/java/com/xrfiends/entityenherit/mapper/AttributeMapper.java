package com.xrfiends.entityenherit.mapper;

import com.xrfiends.entityenherit.domain.Attribute;
import com.xrfiends.entityenherit.domain.Base;
import com.xrfiends.entityenherit.dto.AttributeDTO;
import com.xrfiends.entityenherit.dto.BaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AttributeMapper extends EntityMapper<AttributeDTO, Attribute> {
}
