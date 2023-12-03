package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
