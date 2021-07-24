package com.sda.goldmann.iss.console;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class Menu {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Menu.class);
    private static Object StringBuilder;


    public static  void printMainMenu(){
        var stringBuilder = new StringBuilder();
        stringBuilder.append("----------Main menu--------\n")
                .append("(1) Show current ISS position")
                .append("(2)calculate ISS speed\n")
                .append("(3)  List of people in the space  ")
                .append("(4) exit aplication");


        LOGGER.trace("{}", StringBuilder);
    }

}
