package edu.hw8.task2;

public class Fibonacci {
    private Fibonacci() {

    }

    public static int computeFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return computeFibonacci(n - 1) + computeFibonacci(n - 2);
    }
}
