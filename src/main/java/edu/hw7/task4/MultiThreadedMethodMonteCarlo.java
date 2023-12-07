package edu.hw7.task4;

public class MultiThreadedMethodMonteCarlo {

    private MultiThreadedMethodMonteCarlo() {

    }

    public static final int THREADS_COUNT = 4;

    public static double multiCalculate(long totalCount) throws InterruptedException {
        long circleCount = 0;
        long iterationsPerProcess = totalCount / THREADS_COUNT;
        CustomThread[] customThreads = new CustomThread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            customThreads[i] = new CustomThread(iterationsPerProcess);
            customThreads[i].start();
        }
        for (CustomThread customThread : customThreads) {
            customThread.join();
            circleCount += customThread.circleCountPerProcess;
        }
        return ((double) circleCount / totalCount) * THREADS_COUNT;
    }
}
