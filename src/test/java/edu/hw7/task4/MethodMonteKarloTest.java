package edu.hw7.task4;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.task4.MethodMonteKarlo.calculate;
import static edu.hw7.task4.MultiThreadedMethodMonteCarlo.multiCalculate;
import static org.assertj.core.api.Assertions.assertThat;

public class MethodMonteKarloTest {

    @Test
    @DisplayName("MethodMonteKarlo Test")
    public void methodMonteKarloTest() {
       Offset approximation = Offset.offset(0.01);
        assertThat(calculate(1000000))
            .isCloseTo(Math.PI, approximation);
        assertThat(calculate(10000000))
            .isCloseTo(Math.PI,approximation);
        assertThat(calculate(100000000))
            .isCloseTo(Math.PI, approximation);
    }

    @Test
    void testMultiThreadIsFaster() throws InterruptedException {
        long point = 10000000;
        long timeStart = System.currentTimeMillis();
        calculate(point);
        long timeEnd = System.currentTimeMillis();
        long time = timeEnd - timeStart;
        long timeStartMultiThreaded = System.currentTimeMillis();
        multiCalculate(point);
        long timeEndMultiThreaded = System.currentTimeMillis();
        long timeMultiThreaded = timeEndMultiThreaded - timeStartMultiThreaded;
        assertThat(time).isGreaterThan(timeMultiThreaded);
    }
}

