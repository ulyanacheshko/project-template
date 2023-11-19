package edu.hw2.task1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

class ExponentTest {
    @DisplayName("Возведения числа в степень")
    @ParameterizedTest(name = " {0} в {1} = {2}")
    @CsvSource({
        "2,2,4",
        "10,2,100",
        "-3.48,2,12.1104",
        "1,0,1",
    })
    void exponentTest(double x, int power, double expected) {
        Expr exponent = new Exponent(new Constant(x), power);
        double response = exponent.evaluate();
        assertThat(response).isEqualTo(expected);
    }

}
