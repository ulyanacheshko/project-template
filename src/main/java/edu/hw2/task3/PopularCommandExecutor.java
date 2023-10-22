package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        int attempt = 0;
        Connection connection = this.manager.getConnection();
        while (attempt <= maxAttempts) {
            try (connection) {
                connection.execute(command);
                LOGGER.info("Command is executed");
                return;
            } catch (Exception e) {
                ConnectionException causedException = new ConnectionException();
                attempt++;
                causedException.initCause(e);
            }
        }
        LOGGER.info("Command not executed");
        throw new ConnectionException("exceeded the number of attempts");
    }
}
