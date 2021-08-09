package com.sda.goldmann.iss.service;

import com.sda.goldmann.iss.model.Person;
import com.sda.goldmann.iss.model.Craft;
import com.sda.goldmann.iss.model.PersonInMeasurement;
import com.sda.goldmann.iss.model.PersonMeasure;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    private final HibernateService hibernateService;

    public PersonService(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    public PersonMeasure create(List<com.sda.goldmann.iss.dto.Person> astronauts) {
        var transaction = hibernateService.getSession().beginTransaction();
        var personMeasure = new PersonMeasure();

        // TODO: this is just for example how entities can be stored
        // TODO: data is not stored the way we want
        // TODO: FIX THAT !!!
        personMeasure.setPersonInMeasurement(astronauts.stream()
                .map(astronaut -> {
                    var personInMeasurement = new PersonInMeasurement();
                    personInMeasurement.setPerson(new Person(
                            astronaut.getFullName(),
                            personInMeasurement
                    ));
                    personInMeasurement.setCraft(new Craft(
                            astronaut.getCraft(),
                            personInMeasurement
                    ));
                    personInMeasurement.setPersonMeasure(personMeasure);

                    return personInMeasurement;
                })
                .collect(Collectors.toSet()));

        hibernateService.getSession().persist(personMeasure);
        transaction.commit();

        return personMeasure;
    }
}
