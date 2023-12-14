package edu.hw8.task2;

import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import static edu.hw8.task2.Fibonacci.computeFibonacci;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedThreadPoolTest {

    @Test
    void fibonacciTest() {
        int threadsCount = 4;
        int countOfNumbers = 6;
        CountDownLatch countDownLatch = new CountDownLatch(countOfNumbers);

        try (FixedThreadPool threadPool = FixedThreadPool.create(threadsCount)) {
            threadPool.start();
            for (int i = 0; i < countOfNumbers; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    getFibonacci(finalI);
                    countDownLatch.countDown();
                });
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    void getFibonacci(int finalI) {
        int result = computeFibonacci(finalI);
        int[] answers = {0, 1, 1, 2, 3, 5, 8};
        assertEquals(result, answers[finalI]);
    }


}
