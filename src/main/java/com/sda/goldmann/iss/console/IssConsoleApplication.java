package com.sda.goldmann.iss.console;

import com.google.inject.Guice;
import com.sda.goldmann.iss.controller.ConsoleController;
import com.sda.goldmann.iss.di.ConfigurationModule;
import com.sda.goldmann.iss.di.ServiceModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IssConsoleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssConsoleApplication.class);

    private IssConsoleApplication() {
    }

    // simulate spring behavior
    public static void run() {
        var scanner = new Scanner();
        var injector = Guice.createInjector(new ConfigurationModule(), new ServiceModule());
        var consoleController = injector.getInstance(ConsoleController.class);

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
                     LOGGER.info("{}", consoleController.getISSSpeed());
                     break;
                 case 3:
                     LOGGER.info("{}", consoleController.getListOfPeople());
                     break;
                 default:
                     LOGGER.info("This option ({}) is not defined", input);
                     break;
             }
        }
    }
}
