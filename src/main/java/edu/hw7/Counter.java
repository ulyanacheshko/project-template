package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value;

    public Counter(int initialValue) {
        value = new AtomicInteger(initialValue);
    }

    public int getValue() {
        return value.get();
    }

    public void incrementCount() throws InterruptedException {
        var firstThread = new Thread(() -> {
            value.incrementAndGet();
        });
        var secondThread = new Thread(() -> {
            value.incrementAndGet();
        });
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();
    }
}
