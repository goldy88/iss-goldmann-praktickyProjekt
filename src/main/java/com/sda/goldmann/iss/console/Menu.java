package com.sda.goldmann.iss.console;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {

    private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);

    public static void printMainMenu() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("\n----- Main menu -----\n" )
                .append("(1) Show current ISS position\n")
                .append("(2) Calculate ISS speed\n")
                .append("(3) List of people in the space\n")
                .append("(0) Exit application");

        LOGGER.info("{}", stringBuilder);

    }

}
