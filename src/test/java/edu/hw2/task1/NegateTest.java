package edu.hw2.task1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

class NegateTest {
    @DisplayName("Отрицание")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "2, -2",
        "-315,315",
        "-3.48,3.48",
        "0,0"
    })
    void negativeTest(double x, double expected) {
        Negate negate = new Negate(new Constant(x));
        double response = negate.evaluate();
        assertThat(response).isEqualTo(expected);
    }
}
