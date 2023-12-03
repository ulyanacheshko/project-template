package edu.hw1;

public class DigitsNumber {

    private static final int NUMBER_BREAKER = 10;


    private DigitsNumber() {

    }

    public static int countDigits(int a) {
        int count = 0;
        int num = a;
        do {
            num /= NUMBER_BREAKER;

            count++;
        }
        while (num != 0);
        return count;
    }

}
