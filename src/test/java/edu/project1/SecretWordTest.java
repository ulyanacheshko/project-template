package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SecretWordTest {
    private final SecretWord secretWord = new SecretWord("business");

    @DisplayName("Открыть букву")
    @Test
    void openLetterTest() {
        boolean input = true;
        Character letter = 'i';
        int index = 3;
        String answer = "business";
        secretWord.maskedAnswerArray(answer);
        boolean response = secretWord.openLetter(index, letter);
        assertThat(input).isEqualTo(response);
    }

    @DisplayName("Количество букв в слове")
    @Test
    void maskedAnswerArrayTest() {
        String answer = "business";
        char[] maskedAnswer = {'*', '*', '*', '*', '*', '*', '*', '*',};
        secretWord.maskedAnswerArray(answer);
        char[] response = secretWord.getMaskedAnswer();
        assertThat(maskedAnswer).isEqualTo(response);
    }
}
