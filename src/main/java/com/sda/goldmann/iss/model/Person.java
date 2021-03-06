package com.sda.goldmann.iss.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, PersonInMeasurement personInMeasurement) {
        this.name = name;
        this.personInMeasurement = Set.of(personInMeasurement);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Set<PersonInMeasurement> personInMeasurement;
}
