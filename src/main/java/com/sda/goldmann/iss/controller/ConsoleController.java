package com.sda.goldmann.iss.controller;

import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

public class ConsoleController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleController.class);

public String getCurrentISSPosition(){
    LOGGER.info("showing current ISS position");
            return"";
}

public float getISSSpeed(){
    LOGGER.info("get current ISS speed");
    return 0f;

}

public List<Object >getListOfPepple(){
LOGGER.info("");
return List.of() ;
}

}
