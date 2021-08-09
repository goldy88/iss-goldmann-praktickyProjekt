package com.sda.goldmann.iss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

    @JsonProperty("name")
    private String fullName;
    private String craft;

}
