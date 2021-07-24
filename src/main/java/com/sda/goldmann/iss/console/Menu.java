package com.sda.goldmann.iss.console;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Menu {

    private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);

    public static  void printMainMenu(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n----------Main menu--------\n")
                .append("(1) Show current ISS position\n")
                .append("(2) calculate ISS speed\n")
                .append("(3) List of people in the space\n")
                .append("(0) exit aplication");

        LOGGER.info(stringBuilder.toString());
    }

}
