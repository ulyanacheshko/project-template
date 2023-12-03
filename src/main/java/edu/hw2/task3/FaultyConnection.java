package edu.hw2.task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new ConnectionException("Faulty connection exception");
        }
        LOGGER.info("Faulty connection execute" + command);
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Faulty connection closed");
    }
}
