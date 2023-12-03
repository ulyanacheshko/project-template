package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw1.BrokenString.fixString;

class BrokenStringTest {
    @DisplayName("Корректное исправление строк")
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
        "оПомигети псаривьтс ртко!и,Помогите исправить строки!",
        "123456,214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "badce,abcde",
    }
    )
    void fixStringCorrectly(String input, String expected){
        String response = fixString(input);
        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Проверка пустой строки")
    void StrIsEmpty() {
        String input = " ";
        String response = fixString(input);
        assertThat(response).isEqualTo(" ");
    }


}
