package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PrintTest {
    private final SecretWord secretWord = new SecretWord("business");
    private final Session session = new Session(secretWord.getSecretWord(), 0);

    @DisplayName("Вывод ошибки и количества попыток")
    @Test
    void printAttemptsTest() {
        int attempts = 0;
        String output = "Missed, mistake " + attempts + " out of 5.";
        String response = Print.printAttempts(session);
        assertThat(output).isEqualTo(response);
    }

    @DisplayName("Вывод отгаданной буквы")
    @Test
    void printHitTest() {
        String output = "Hit!";
        String response = Print.printHit();
        assertThat(output).isEqualTo(response);
    }

    @DisplayName("Данную букву уже вводили")
    @Test
    void printAlreadyEnteredTest() {
        String output = "This letter has already been entered";
        String response = Print.printAlreadyEntered();
        assertThat(output).isEqualTo(response);
    }

    @DisplayName("Вывод победы")
    @Test
    void printWinTest() {
        String output = new GuessResult.Win().message();
        String response = Print.printWin();
        assertThat(output).isEqualTo(response);
    }

    @DisplayName("Вывод проигрыша")
    @Test
    void printLosingTest() {
        String word = "business";
        String output = new GuessResult.Defeat(secretWord).message();
        String response = Print.printLosing(secretWord);
        assertThat(output).isEqualTo(response);
    }

}
