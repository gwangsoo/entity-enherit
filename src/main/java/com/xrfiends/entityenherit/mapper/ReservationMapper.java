package com.xrfiends.entityenherit.mapper;

import com.xrfiends.entityenherit.domain.Reservation;
import com.xrfiends.entityenherit.dto.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {DetailMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper extends EntityMapper<ReservationDTO, Reservation> {
}
