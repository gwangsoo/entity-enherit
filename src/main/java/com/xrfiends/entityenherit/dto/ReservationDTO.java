package com.xrfiends.entityenherit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO implements Serializable {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String name;

    private Set<DetailDTO> details;
}
