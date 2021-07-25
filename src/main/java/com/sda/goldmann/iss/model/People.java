package com.sda.goldmann.iss.model;

import lombok.Data;
import java.util.List;

@Data
public class People {
    List<Person> people;
    private Integer number;
    private String message;
}
