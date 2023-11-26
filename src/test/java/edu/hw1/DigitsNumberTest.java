package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import static edu.hw1.DigitsNumber.countDigits;
import org.junit.jupiter.params.provider.CsvSource;

class DigitsNumberTest {
    @DisplayName("Проверка различных корректных значений ")
    @ParameterizedTest(name = "number {0} - countOfDigits is {1}")
    @CsvSource({
        "3217,4",
        "1,1",
        "9999999,7",
        "128,3"
    })
    void countDigitsTest(int input, int expected) {
        int response = countDigits(input);
        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка нуля")
    void DigitIsNull() {
        int input = 0;
        int response = countDigits(input);
        assertThat(response).isEqualTo(1);
    }

}
