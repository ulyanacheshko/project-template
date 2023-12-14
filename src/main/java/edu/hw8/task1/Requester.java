package edu.hw8.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Requester implements Runnable {
    private static final int BUFFER_CAPACITY = 1024;
    private final static Logger LOGGER = LogManager.getLogger();
    private static final Map<String, String> MESSAGES = Map.of(
        "личности", "Не переходи на личности там, где их нет.",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверен — твоя победа не за горами.",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления."
    );

    private final Socket clientSocket;
    private String request = "";

    private String responseMessage = "";

    public Requester(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            byte[] buffer = new byte[BUFFER_CAPACITY];
            while (true) {
                int bytesRead = inputStream.read(buffer);
                if (bytesRead > 0) {
                    request = new String(buffer, 0, bytesRead);
                    LOGGER.info("CLIENT:" + request);
                    responseMessage = MESSAGES.getOrDefault(request, "На данное сообщения ответа нет");
                    LOGGER.info("SERVER: " + responseMessage);
                    outputStream.write(responseMessage.getBytes());
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
