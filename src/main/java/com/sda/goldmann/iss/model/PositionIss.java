package com.sda.goldmann.iss.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PositionIss {

    private Integer timestamp;
    private String message;
    @JsonProperty("iss_position")
    private Coordinates cords;

}
