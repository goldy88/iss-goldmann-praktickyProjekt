package com.sda.goldmann.iss.controller;


import com.sda.goldmann.iss.dto.Person;
import com.sda.goldmann.iss.dto.Position;
import com.sda.goldmann.iss.model.IssSpeed;
import com.sda.goldmann.iss.service.IssServiceImpl;
import com.sda.goldmann.iss.service.PersonService;
import com.sda.goldmann.iss.service.PositionService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleController {

    private final IssServiceImpl issService;
    private final PositionService positionService;
    private final PersonService personService;

    public ConsoleController(IssServiceImpl issService, PositionService positionService, PersonService personService) {
        this.issService = issService;
        this.positionService = positionService;
        this.personService = personService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleController.class);

    public Position getCurrentISSPosition() {
        LOGGER.info("Showing current ISS position...");
        var issPosition = issService.getIssPosition();

        positionService.create(issPosition);
        return issPosition;
    }

    public IssSpeed getISSSpeed() {
        LOGGER.info("Get current ISS speed...");
        var issPosition1 = issService.getIssPosition();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var issPosition2 = issService.getIssPosition();
        return positionService.storeSpeed(issPosition1, issPosition2);
    }

    public List<Person> getListOfPeople() {
        LOGGER.info("Showing Astronauts...");
        List<Person> astronauts = issService.getAstronauts();

        personService.create(astronauts);
        return astronauts;
    }

}
