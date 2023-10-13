package edu.hw1;

public class DigitsNumber {
    private static final int CONST_TEN = 10;

    private DigitsNumber() {

    }

    public static int countDigits(int a) {
        int count = 0;
        int num = a;
        do {
            num /= CONST_TEN;
            count++;
        }
        while (num != 0);
        return count;
    }

}
