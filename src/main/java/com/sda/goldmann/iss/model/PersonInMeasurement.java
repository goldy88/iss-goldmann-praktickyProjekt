package com.sda.goldmann.iss.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "person_in_measurement")
public class PersonInMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="measure_id", referencedColumnName="id")
    private PersonMeasure personMeasure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="person_id", referencedColumnName="id")
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="craft_id", referencedColumnName="id")
    private Craft craft;

}
