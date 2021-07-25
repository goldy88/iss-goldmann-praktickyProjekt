package com.sda.goldmann.iss.controller;
import com.sda.goldmann.iss.model.Person;
import com.sda.goldmann.iss.model.PositionIss;
import com.sda.goldmann.iss.service.IssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ConsoleController {

private final IssService issService;

 public ConsoleController(IssService issService){
     this.issService = issService;
 }

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleController.class);

    public PositionIss getCurrentISSPosition() {
        LOGGER.info("showing current ISS position");
        return issService.getPosition();

    }
    public float getISSSpeed() {
        LOGGER.info("get current ISS speed");
        return 0f;
    }

    public List<Person> getListOfPeople() {
        LOGGER.info("List of people in the space");

        return issService.getAstronauts();
    }

}
