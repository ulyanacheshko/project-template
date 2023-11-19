package edu.hw3.task4;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw3.task4.RomanNumerals.intToRoman;

class RomanNumeralsTest {

    @DisplayName("Тест RomanNumerals")
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(value = {
        "2,II",
        "12,XII",
        "16,XVI"
    })
    public void romanNumeralsTest(int input, String expected) {
        String response = intToRoman(input);
        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Некорректный ввод")
    public void incorrectTest() {
        assertThatThrownBy(() -> intToRoman(5321)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Нулевое значение")
    public void nullTest() {
        String response = intToRoman(0);
        assertThat(response).isEqualTo("N");
    }

}
