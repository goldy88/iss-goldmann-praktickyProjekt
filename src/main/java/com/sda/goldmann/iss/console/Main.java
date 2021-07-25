package com.sda.goldmann.iss.console;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.goldmann.iss.Application;
import com.sda.goldmann.iss.client.IssClient;
import com.sda.goldmann.iss.controller.ConsoleController;
import com.sda.goldmann.iss.service.IssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void run() {
        var scanner = new Scanner();
        IssClient issClient=new IssClient();
        ObjectMapper objectMapper = new ObjectMapper();
        IssService issService=new IssService(issClient, objectMapper);

        ConsoleController consoleController = new ConsoleController(issService);

        while (true) {
            Menu.printMainMenu();
            int input = scanner.loadUserInput();
            if (input == 0) {
                break;
            }

            switch (input) {
                case 1:
                    LOGGER.info("{}", consoleController.getCurrentISSPosition());
                    break;
                case 2:
                    LOGGER.info("{}",consoleController.getISSSpeed());
                    break;
                case 3:
                   LOGGER.info("{}", consoleController.getListOfPeople());
                    break;
                default:
                    LOGGER.info("this option ({}) is not defined ", input);
                    break;

            }
        }
    }
}
