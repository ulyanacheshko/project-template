package edu.hw7.task4;

import java.util.Random;

public class MethodMonteKarlo {
    private MethodMonteKarlo() {

    }

    public static final int CIRCLE_QUARTER = 4;

    public static double calculate(long totalCount) {
        long circleCount = 0;
        for (int i = 0; i < totalCount; i++) {
            double x = new Random().nextDouble();
            double y = new Random().nextDouble();
            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }
        return ((double) circleCount / totalCount) * CIRCLE_QUARTER;
    }
}
