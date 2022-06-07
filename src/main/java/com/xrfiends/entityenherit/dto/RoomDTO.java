package com.xrfiends.entityenherit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RoomDTO extends BaseDTO implements Serializable {

    @Schema(description = "회의실번호", defaultValue = "R01", example = "R01")
    private String roomNo;

    private Set<AttendeeDTO> attendees;
}
