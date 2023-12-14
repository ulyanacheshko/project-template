package edu.hw8.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client extends Thread {
    private static String serverAddress;
    private static int serverPort;
    private static final int BUFFER_CAPACITY = 1024;
    public static final String EXIT = "exit";
    public static String message;
    private final static Logger LOGGER = LogManager.getLogger();

    public Client(String serverAddress, int serverPort, String message) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.message = message;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(serverAddress, serverPort)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            byte[] buffer = new byte[BUFFER_CAPACITY];
            while (true) {
                LOGGER.info("Input word:");
                if (message.equals(EXIT)) {
                    break;
                }
                outputStream.write(message.getBytes());
                getAnswer(buffer, inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAnswer(byte[] buffer, InputStream inputStream) throws IOException {
        int bytesRead = inputStream.read(buffer);
        return new String(buffer, 0, bytesRead);
    }
}
