package edu.hw7;

import java.util.stream.IntStream;

public class Factorial {

    public int calculateFactorial(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        return IntStream.rangeClosed(1, n)
            .parallel()
            .reduce((first, second) -> first * second)
            .getAsInt();
    }
}
