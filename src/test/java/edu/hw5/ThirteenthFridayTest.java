package edu.hw5;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import static edu.hw5.ThirteenthFriday.getDates;
import static edu.hw5.ThirteenthFriday.getNearestThirteenthFriday;

class ThirteenthFridayTest {
    private static Stream<Arguments> inputDates() {
        return Stream.of(
            Arguments.of("1925",List.of("1925-02-13", "1925-03-13", "1925-11-13")),
            Arguments.of("2024", List.of("2024-09-13", "2024-12-13")),
            Arguments.of("2003", List.of("2003-06-13"))
        );
    }
    private static Stream<Arguments> inputThirteenthFriday() {
        return Stream.of(
            Arguments.of(
                LocalDate.of(1925, 2, 1),
                LocalDate.of(1925,2,13)),
            Arguments.of(
                LocalDate.of(2024, 7, 8),
                LocalDate.of(2024,9,13)),
            Arguments.of(
                LocalDate.of(2010, 5, 11),
                LocalDate.of(2010,8,13))
        );
    }

    @ParameterizedTest
    @MethodSource("inputDates")
    @DisplayName("Корректные данные")
    public void CorrectInputDatesTest(int input, List<LocalDate> dates) {
        Assertions.assertThat(getDates(input)).isEqualTo(dates);
    }
    @ParameterizedTest
    @MethodSource("inputThirteenthFriday")
    @DisplayName("Корректные данные")
    public void CorrectInputThirteenthFridayTest(LocalDate input, LocalDate response) {
        Assertions.assertThat(getNearestThirteenthFriday(input)).isEqualTo(response);
    }
}
