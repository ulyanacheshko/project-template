package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;

public class CustomThread extends Thread {
    public long circleCountPerProcess;
    private long iterationsPerProcess;

    public CustomThread(long iterationsPerProcess) {
        this.iterationsPerProcess = iterationsPerProcess;
    }

    public void run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double x = 0;
        double y = 0;
        circleCountPerProcess = 0;
        for (int i = 0; i < iterationsPerProcess; i++) {
            x = random.nextDouble();
            y = random.nextDouble();
            if ((x * x + y * y) < 1.0) {
                circleCountPerProcess++;
            }
        }
    }
}
