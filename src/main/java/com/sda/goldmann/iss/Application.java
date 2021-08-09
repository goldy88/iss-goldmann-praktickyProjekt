package com.sda.goldmann.iss;

import com.sda.goldmann.iss.console.IssConsoleApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        // We need to load properties, and configure flyway
        // config is in resources/flyway.properties
        Properties properties = new Properties();
        InputStream resourceAsStream = Application.class.getClassLoader().getResourceAsStream("flyway.properties");
        properties.load(resourceAsStream);

        // initialize flyway and run it
        // flyway will update DB schema according to migration scripts
        // migration script are in resources/db/migration
        Flyway flyway = Flyway.configure().configuration(properties).load();
        flyway.migrate();

        // after we successfully updated/created DB, we can run our APP
        LOGGER.info("Starting ISS APP..."); // trace, debug, info, warn, error
        IssConsoleApplication.run();
    }

}
