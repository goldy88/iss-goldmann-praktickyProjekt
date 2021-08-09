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
@Table(name = "craft")
public class Craft {

    public Craft() {
    }

    public Craft(String name) {
        this.name = name;
    }

    public Craft(String name, PersonInMeasurement personInMeasurement) {
        this.name = name;
        this.personInMeasurement = Set.of(personInMeasurement);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "craft_id")
    private Set<PersonInMeasurement> personInMeasurement;
}
