package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw5.RegexAdditionalTask.*;

class RegexAdditionalTaskTest {
    @DisplayName("Нечетной длины")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "01000,true",
        "10,false",
        "110,true",
        "0010,false"
    }
    )
    void isOddLengthTest(String input, boolean expected) {
        boolean response = isOddLength(input);
        assertThat(response).isEqualTo(expected);
    }
    @DisplayName("Начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "01000,true",
        "100,false",
        "1010,true",
        "0010,false"
    }
    )
    void isZeroOddOrOneEvenLengthTest(String input, boolean expected) {
        boolean response = isZeroOddOrOneEvenLength(input);
        assertThat(response).isEqualTo(expected);
    }
    @DisplayName("Любая строка, кроме 11 или 111")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "01000,true",
        "11,false",
        "1010,true",
        "111,false"
    }
    )
    void isNotTwoOrThreeOnesTest(String input, boolean expected) {
        boolean response = isNotTwoOrThreeOnes(input);
        assertThat(response).isEqualTo(expected);
    }
    @DisplayName("Каждый нечетный символ равен 1")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "10111,true",
        "11111,true",
        "01000,false",
        "11,true",
        "000,false",
        "101,true"
    }
    )
    void isEveryOddSymbolIsOneTest(String input, boolean expected) {
        boolean response = isEveryOddSymbolIsOne(input);
        assertThat(response).isEqualTo(expected);
    }
    @DisplayName("Нет последовательных 1")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "1011,false",
        "11111,false",
        "01000,true",
        "110010,false",
        "000,true",
        "10111010,false"
    }
    )
    void noСonsecutiveZerosTest(String input, boolean expected) {
        boolean response = noConsisteveOnes(input);
        assertThat(response).isEqualTo(expected);
    }



}
