package com.sda.goldmann.iss.service;

import com.sda.goldmann.iss.dto.Person;
import com.sda.goldmann.iss.dto.Position;
import java.util.List;

public interface IssService {

    List<Person> getAstronauts();
    Position getIssPosition();

}
