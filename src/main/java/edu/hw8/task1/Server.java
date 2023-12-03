package edu.hw8.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server extends Thread {
    private static int serverPort;
    private static int maxConnections;
    private static ExecutorService executorService;
    private final static Logger LOGGER = LogManager.getLogger();

    public Server(int serverPort, int maxConnections) {
        this.serverPort = serverPort;
        this.maxConnections = maxConnections;
        this.executorService = Executors.newFixedThreadPool(maxConnections);
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            LOGGER.info("Server is listening on port: " + serverPort);
            int clientCount = 0;
            while (clientCount < maxConnections) {
                Socket clientSocket = serverSocket.accept();
                executorService.execute(new Requester(clientSocket));
                ++clientCount;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopServer() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        LOGGER.info("Server stopped");
    }
}
