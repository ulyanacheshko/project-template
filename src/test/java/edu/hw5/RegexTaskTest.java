package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw5.RegexTask.*;


class RegexTaskTest {
    @DisplayName("Содержит не менее 3 символов, причем третий символ равен 0")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "01000,true",
        "10,false",
        "110,true",
        "0010,false"
    }
    )
    void atLeastTreeCharactersTest(String input, boolean expected) {
        boolean response = atLeastTreeCharacters(input);
        assertThat(response).isEqualTo(expected);
    }
    @DisplayName("Начинается и заканчивается одним и тем же символом")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "01000,true",
        "1010,false",
        "00,true",
        "1010101,true"
    }
    )
    void beginAndEndSameTest(String input, boolean expected) {
        boolean response = beginAndEndSame(input);
        assertThat(response).isEqualTo(expected);
    }
    @DisplayName("Длина не менее 1 и не более 3")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "010,true",
        "10,true",
        "1,true",
        "0001,false"
    }
    )
    void moreOneAndLessThreeTest(String input, boolean expected) {
        boolean response = moreOneAndLessThree(input);
        assertThat(response).isEqualTo(expected);
    }
}
