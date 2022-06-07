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
public class SeatDTO extends BaseDTO implements Serializable {

    @Schema(description = "좌석번호", defaultValue = "S01", example = "S01")
    private String seatNo;

    private Set<AttributeDTO> attributes;
}
