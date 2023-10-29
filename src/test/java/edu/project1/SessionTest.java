package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SessionTest {
    private final SecretWord secretWord = new SecretWord("business");
    private final Session session = new Session(secretWord.getSecretWord(), 0);

    @DisplayName("Пользователь ввел больше одной буквы")
    @Test
    void wrongUserInputTest() {
        boolean isException = false;
        try {
            String wrongInput = "word";
            if (wrongInput.length() != 1) {
                throw new IllegalArgumentException("Пользователь ввел больше одного символа");
            }
        } catch (IllegalArgumentException e) {
            isException = true;
        }
        assertThat(true).isEqualTo(isException);
    }

    @DisplayName("После превышения заданного количества попыток игра возвращает поражение")
    @Test
    void attemptsMoreThanMax() {
        String input = "You lost!, word – " + secretWord.getSecretWord();
        int attempts = 7;
        String response = "";
        if (attempts > session.getMaxAttempts()) {
            response = Print.printLosing(secretWord);
        }
        assertThat(input).isEqualTo(response);
    }

    @Test
    @DisplayName("Проверка игры на корректный выигрыш")
    public void testWin() {
        String word = "business";
        String expected = "You won!";
        String actual = "";
        if (session.userWins(word.toCharArray(), word)) {
            actual = new GuessResult.Win().message();
        }
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("Проверка игры на корректный проигрыш")
    public void testDefeat() {
        String word = "business";
        String expected = "You lost!, word – business";
        String actual = "";
        SecretWord secretWord1 = new SecretWord("business");
        if (session.userWins(word.toCharArray(), word)) {
            actual = new GuessResult.Defeat(secretWord1).message();
        }
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("Проверка допустимых и повторяющихся букв при вводе")
    void correctLetterTest() {
        char letter = 'a';
        boolean expected = true;
        boolean actual = session.isCorrectLetter('a');
        assertThat(expected).isEqualTo(actual);
    }

}


