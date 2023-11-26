package edu.hw1;

import static edu.hw1.SpecialPalindrom.isPalindromeDescendant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;


class SpecialPalindromTest{
    @DisplayName("Проверка числа и его потомков на падиндром")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "11211230,true",
        "13001120,true",
        "23336014,true",
        "11,true",
        "1179,false",
        "912195,false",
        "123, false"
    }
    )
    void isPalindromTest(int input, boolean expected) {
        boolean response = isPalindromeDescendant(input);
        assertThat(response).isEqualTo(expected);
    }

}
