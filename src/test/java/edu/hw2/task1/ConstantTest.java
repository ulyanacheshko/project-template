package edu.hw2.task1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

class ConstantTest {
    @DisplayName("Константа")
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "2, 2",
        "-315,-315",
        "-3.48,-3.48",
        "0,0"
    })
    void constTest(double x, double expected) {
        Constant constNum = new Constant(x);
        double response = constNum.evaluate();
        assertThat(response).isEqualTo(expected);
    }

}
