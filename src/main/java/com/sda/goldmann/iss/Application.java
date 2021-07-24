package com.sda.goldmann.iss;

import com.sda.goldmann.iss.console.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        LOGGER.info("starting iss app.....");
        Main.run();
    }
}
