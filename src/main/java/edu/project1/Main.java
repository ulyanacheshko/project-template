package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {

    private Main() {

    }

    private final static Logger LOGGER = LogManager.getLogger();
    private static String filename = "dictionary.txt";
    private static Dictionary dictionary = new Dictionary(filename);
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            LOGGER.info("Enter 1 to start the game or 2 for exit");
            int choice = SCANNER.nextInt();
            switch (choice) {
                case (1) -> startGame();
                case (2) -> {
                    LOGGER.info("Thanks for the game, bye!");
                    System.exit(0);
                }
                default -> {
                }
            }
        }
    }

    private static void startGame() {
        SecretWord secretWord = new SecretWord(dictionary.getRandomWordFromList());
        Session session = new Session(secretWord.getSecretWord(), 0);
        session.gameLoop(secretWord);
    }
}
