package edu.hw2.task1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

class MultiplicationTest {
    @DisplayName("Произведение")
    @ParameterizedTest(name = " {0} * {1} = {2}")
    @CsvSource({
        "2,2,4",
        "10,2,20",
        "-3.48,2,-6.96",
        "1,0,0",
    })
    void multTest(double x1, double x2, double expected) {
        Multiplication mult = new Multiplication(new Constant(x1),new Constant(x2));
        double response = mult.evaluate();
        assertThat(response).isEqualTo(expected);
    }
}
