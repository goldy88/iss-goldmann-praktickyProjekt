package com.sda.goldmann.iss.console;

import com.sda.goldmann.iss.Application;
import com.sda.goldmann.iss.controller.ConsoleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    public static void run() {
        var scanner = new Scanner();
        ConsoleController consoleController = new ConsoleController();
        while (true) {

            Menu.printMainMenu();
            int input = scanner.loadUserInput();
            if (input == 0) {
                break;
            }

    switch (input){
        case 1:
            consoleController.getCurrentISSPosition();
            break;
        case 2:
            consoleController.getISSSpeed();
            break;
        case 3:
            consoleController.getListOfPepple();
            break;
        default:
            LOGGER.info("this options ({}) not defined",input);
            break;

    }



        }


    }

}
