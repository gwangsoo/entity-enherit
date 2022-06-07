package com.xrfiends.entityenherit.mapper;

import com.xrfiends.entityenherit.domain.Base;
import com.xrfiends.entityenherit.domain.Reservation;
import com.xrfiends.entityenherit.domain.Room;
import com.xrfiends.entityenherit.domain.Seat;
import com.xrfiends.entityenherit.dto.BaseDTO;
import com.xrfiends.entityenherit.dto.ReservationDTO;
import com.xrfiends.entityenherit.dto.RoomDTO;
import com.xrfiends.entityenherit.dto.SeatDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseMapper extends EntityMapper<BaseDTO, Base> {
    @Override
    @SubclassMapping( source = Room.class, target = RoomDTO.class )
    @SubclassMapping( source = Seat.class, target = SeatDTO.class )
    BaseDTO toDto(Base e);

    @Override
    @SubclassMapping( source = SeatDTO.class, target = Seat.class )
    @SubclassMapping( source = RoomDTO.class, target = Room.class )
    Base toEntity(BaseDTO d);
}
