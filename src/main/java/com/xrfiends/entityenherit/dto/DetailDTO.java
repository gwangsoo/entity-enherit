package com.xrfiends.entityenherit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailDTO implements Serializable {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String baseId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BaseDTO base;
}
