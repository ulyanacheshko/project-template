package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static edu.hw1.KaprekarConst.countK;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;

class KaprekarConstTest {
    @DisplayName("Количество шагов для получения числа Капрекара")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "6621,5",
        "6554,4",
        "1234,3"
    }
    )
    void kaprekarConstCorrectInput(int input, int expected) {
        int response = countK(input);
        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка константы Капрекара - 6174")
    void NumIsKaprekarConst() {
        int input = 6174;
        int response = countK(input);
        assertThat(response).isEqualTo(0);
    }

    @Test
    @DisplayName("Проверка числа больше чем четырехзначное")
    void NumIsMoreFourDigits() {
        int input = 123456;
        assertThatThrownBy(() -> countK(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка числа меньше 1000")
    void NumIsLessThanThousand() {
        int input = 12;
        assertThatThrownBy(() -> countK(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка числа c одинаковыми цифрами")
    void SameDigitsInTheNumber() {
        int input = 2222;
        assertThatThrownBy(() -> countK(input)).isInstanceOf(IllegalArgumentException.class);
    }

}
