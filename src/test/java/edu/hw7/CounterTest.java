package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {
    @Test
    @DisplayName("countTest")
    void testCounting() throws InterruptedException {
        int expectedCount = 100_000;
        var counter = new Counter(expectedCount);
        counter.incrementCount();
        assertThat(counter.getValue())
            .isEqualTo(2 + expectedCount);
    }
}
