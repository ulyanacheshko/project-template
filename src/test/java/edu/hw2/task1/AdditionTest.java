package edu.hw2.task1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

class AdditionTest {
    @DisplayName("Сложение")
    @ParameterizedTest(name = " {0} + {1} = {2}")
    @CsvSource({
        "2,2,4",
        "10,2,12",
        "-3.48,2,-1.48",
        "1,0,1",
    })
    void addTest(double x1, double x2, double expected) {
        Addition sum = new Addition(new Constant(x1),new Constant(x2));
        double response = sum.evaluate();
        assertThat(response).isEqualTo(expected);
    }
}
