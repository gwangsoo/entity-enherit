package com.xrfiends.entityenherit.mapper;

import com.xrfiends.entityenherit.domain.Detail;
import com.xrfiends.entityenherit.dto.DetailDTO;
import com.xrfiends.entityenherit.repository.BaseRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {BaseMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DetailMapper implements EntityMapper<DetailDTO, Detail> {
    @Autowired
    BaseRepository baseRepository;

    @Override
    @Mapping(target = "base", expression = "java(d.getBaseId()==null?null:baseRepository.findById(d.getBaseId()).orElse(null))")
    public abstract Detail toEntity(DetailDTO d);
}
