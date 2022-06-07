package com.xrfiends.entityenherit.mapper;

import com.xrfiends.entityenherit.domain.Reservation;
import com.xrfiends.entityenherit.domain.Seat;
import com.xrfiends.entityenherit.dto.ReservationDTO;
import com.xrfiends.entityenherit.dto.RoomDTO;
import com.xrfiends.entityenherit.dto.SeatDTO;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {AttributeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class SeatMapper implements EntityMapper<SeatDTO, Seat> {
    @BeforeMapping
    protected void generateId(SeatDTO d) {
        if (d != null && !StringUtils.hasLength(d.getId())) {
            d.setId(UUID.randomUUID().toString());
        }
    }
}
