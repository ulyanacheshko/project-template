package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Print {

    private Print() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void printInfo(Session session, SecretWord secretWord) {
        LOGGER.info("The word: " + String.valueOf(secretWord.getMaskedAnswer()));
        LOGGER.info("Guess a letter:");
    }

    public static String printAttempts(Session session) {
        String output = "Missed, mistake " + session.getAttempts() + " out of 5.";
        LOGGER.info(output);
        return output;
    }

    public static String printHit() {
        String output = "Hit!";
        LOGGER.info(output);
        return output;
    }

    public static String printAlreadyEntered() {
        String output = "This letter has already been entered";
        LOGGER.info(output);
        return output;
    }

    public static String printWin() {
        String result = new GuessResult.Win().message();
        LOGGER.info(result);
        return result;
    }

    public static String printLosing(SecretWord secretWord) {
        String result = new GuessResult.Defeat(secretWord).message();
        LOGGER.info(result);
        return result;
    }

}
