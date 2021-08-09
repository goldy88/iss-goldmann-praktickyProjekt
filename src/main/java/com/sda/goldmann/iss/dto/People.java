package com.sda.goldmann.iss.dto;

import java.util.List;
import lombok.Data;

@Data
public class People {

    private List<Person> people;
    private Integer number;
    private String message;

}
