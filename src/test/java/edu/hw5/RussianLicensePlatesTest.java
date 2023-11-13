package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw5.RussianLicensePlates.isLicensePlates;


class RussianLicensePlatesTest {
    @DisplayName("Проверка российских номерных знаков")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "А123ВЕ777,true",
        "О777ОО177,true",
        "123АВЕ777,false",
        "А123ВГ77,false",
        "А123ВЕ7777,false"
    }
    )
    void checkRussianLicensePlatesTest(String input, boolean expected) {
        boolean response = isLicensePlates(input);
        assertThat(response).isEqualTo(expected);
    }

}
