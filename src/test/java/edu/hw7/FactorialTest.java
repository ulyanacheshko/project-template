package edu.hw7;

import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;

class FactorialTest {
    @ParameterizedTest(name = " {0} -> {1}")
    @CsvSource({
        "5,120",
        "4,24",
        "7,5040"
    }
    )
    public void factorialTest(int value, int expected) {
        Factorial factorial = new Factorial();
        int response = factorial.calculateFactorial(value);
        assertThat(response).isEqualTo(expected);
    }

}
