package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw5.CheckingPasswords.isPassword;


class CheckingPasswordsTest {
    @DisplayName("Проверка паролей")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "ulia@17134561!4,true",
        "taniakldr,false",
        "sakm#239,true"
    }
    )
    void checkPasswordTest(String input, boolean expected) {
        boolean response = isPassword(input);
        assertThat(response).isEqualTo(expected);
    }

}
