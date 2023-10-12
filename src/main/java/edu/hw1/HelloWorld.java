package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
    private HelloWorld() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void writeHelloWorld() {
        LOGGER.info("Привет, мир!");
    }
}
