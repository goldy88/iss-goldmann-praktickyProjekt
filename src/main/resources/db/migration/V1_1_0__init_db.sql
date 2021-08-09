USE iss;

drop table IF EXISTS position_measure;
drop table IF EXISTS iss_speed;
drop table IF EXISTS person_in_measurement;
drop table IF EXISTS person_measure;
drop table IF EXISTS craft;
drop table IF EXISTS person;


create TABLE iss_speed(
	id bigint PRIMARY KEY AUTO_INCREMENT,
    speed float NOT NULL,
    created_at timestamp NOT NULL
);


create TABLE position_measure(
	id bigint PRIMARY KEY AUTO_INCREMENT,
    measure_time_seconds bigint NOT NULL,
    latitude float NOT NULL,
    longitude float NOT NULL,
    created_at timestamp NOT NULL,
    iss_speed_id bigint  NULL,
    FOREIGN KEY (iss_speed_id) REFERENCES iss_speed(id)
);


create TABLE person_measure(
	id bigint PRIMARY KEY AUTO_INCREMENT,
	created_at timestamp NOT NULL
);


create TABLE craft(
	id bigint PRIMARY KEY AUTO_INCREMENT,
	name varchar(40)
);


create TABLE person(
	id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(40)
);


create TABLE person_in_measurement(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    measure_id bigint NOT NULL,
    person_id bigint NOT NULL,
    craft_id bigint NOT NULL,
    FOREIGN KEY (measure_id) REFERENCES person_measure(id),
    FOREIGN KEY (craft_id) REFERENCES craft(id),
    FOREIGN KEY (person_id) REFERENCES person(id)
);