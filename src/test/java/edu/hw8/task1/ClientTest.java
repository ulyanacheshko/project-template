package edu.hw8.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;

class ClientTest {
    private Server server;
    private PipedOutputStream serverOutput;
    private ByteArrayOutputStream clientOutput;
    public static final String EXIT = "exit";
    private static final Map<String, String> MESSAGES = Map.of(
        "личности", "Не переходи на личности там, где их нет.",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверен — твоя победа не за горами.",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления."
    );
    @BeforeEach
    void startServer() {
        serverOutput = new PipedOutputStream();
        clientOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(clientOutput));
        server = new Server(8080,2);
        server.start();
    }

    @AfterEach
    void stoppedServer() throws IOException, InterruptedException {
        sleep(500);
        if (server.isAlive()) {
            server.stopServer();
        }
        serverOutput.close();
        clientOutput.close();
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testSingleClientServer() throws IOException, InterruptedException {

        String request = "глупый " + EXIT;
        try (var inputStream = new ByteArrayInputStream(request.getBytes())) {
            System.setIn(inputStream);
            Client client = new Client("localhost",8080,request);
            client.start();
            sleep(1000);
        }
        String responseMessage =  MESSAGES.getOrDefault("глупый","На данное сообщения ответа нет");
        String response = "SERVER: " + responseMessage;
        assertThat(response).isEqualTo("SERVER: А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
    }
    @Test
    void testMultiClientServer() throws IOException, InterruptedException {
        String firstRequest = "личности " + EXIT;
        String secondRequest = "глупый " +EXIT;
        String firstExpected = "SERVER: Не переходи на личности там, где их нет.";
        String secondExpected = "SERVER: А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.";

        try (var inputStream = new ByteArrayInputStream(firstRequest.getBytes())) {
            System.setIn(inputStream);
            Client firstClient = new Client("localhost",8080,firstRequest);
            firstClient.start();
            sleep(1000);
        }
        String firstResponseMessage = "SERVER: " + MESSAGES.getOrDefault("личности","На данное сообщения ответа нет");
        assertThat(firstResponseMessage).isEqualTo(firstExpected );
        try (var inputStream = new ByteArrayInputStream(secondRequest.getBytes())) {
            System.setIn(inputStream);
            Client secondClient = new Client("localhost",8080,secondRequest);
            secondClient.start();
            sleep(1000);
        }
        String secondResponseMessage = "SERVER: " + MESSAGES.getOrDefault("глупый","На данное сообщения ответа нет");
        assertThat(secondResponseMessage).isEqualTo(secondExpected);
    }

}
