package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class FixedThreadPool implements ThreadPool {
    private final Thread[] threads;
    private final int threadsCount;
    private final BlockingQueue<Runnable> tasks;
    private final int waitTime = 50;

    private FixedThreadPool(int threadsCount) {
        this.threadsCount = threadsCount;
        threads = new Thread[threadsCount];
        tasks = new LinkedBlockingQueue<>();
    }

    public static FixedThreadPool create(int threadCount) {
        return new FixedThreadPool(threadCount);
    }

    @Override
    public void start() {
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = tasks.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public synchronized void execute(Runnable runnable) {
        tasks.add(runnable);
    }

    @Override
    public synchronized void close() throws InterruptedException {
        while (!tasks.isEmpty()) {
            wait(waitTime);
        }
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}

