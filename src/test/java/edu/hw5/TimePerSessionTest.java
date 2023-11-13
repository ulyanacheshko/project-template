package edu.hw5;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw5.TimePerSession.getAverageDuration;

class TimePerSessionTest {
    private static Stream<Arguments> input() {
        return Stream.of(
            Arguments.of(
                List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"),
                "3ч 40м"
            ),
            Arguments.of(
                List.of("2022-03-12, 10:00 - 2022-03-12, 10:30", "2022-04-01, 20:30 - 2022-04-01, 21:00"),
                "0ч 30м"
            ),
            Arguments.of(
                List.of("2022-03-12, 19:00 - 2022-03-12, 20:00", "2022-04-01, 09:00 - 2022-04-01, 12:03"),
                "2ч 1м"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    @DisplayName("Корректные данные")
    public void CorrectInputTest(List<String> visitDates, String output) {
        Assertions.assertThat(getAverageDuration(visitDates)).isEqualTo(output);
    }

    @Test
    public void WrongInputTest() {
        Assertions.assertThatThrownBy(() -> getAverageDuration(List.of("")))
            .isInstanceOf(RuntimeException.class);
    }

}
