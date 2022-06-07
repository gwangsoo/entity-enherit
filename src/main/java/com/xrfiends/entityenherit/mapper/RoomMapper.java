package com.xrfiends.entityenherit.mapper;

import com.xrfiends.entityenherit.domain.Room;
import com.xrfiends.entityenherit.dto.RoomDTO;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {AttendeeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RoomMapper implements EntityMapper<RoomDTO, Room> {
    @BeforeMapping
    protected void generateId(RoomDTO d) {
        if(d != null && !StringUtils.hasLength(d.getId())) {
            d.setId(UUID.randomUUID().toString());
        }
        if(d != null && d.getAttendees() != null) {
            d.getAttendees().forEach(attendeeDTO -> {
                attendeeDTO.setRoomId(d.getId());
            });
        }
    }
}
