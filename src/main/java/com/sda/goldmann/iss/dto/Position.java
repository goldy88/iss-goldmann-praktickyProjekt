package com.sda.goldmann.iss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Position {

    private Long timestamp;
    private String message;
    @JsonProperty("iss_position")
    private Cords cords;

}
