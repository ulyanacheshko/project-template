package edu.hw1;

import java.util.Arrays;

public class KaprekarConst {

    public static final int K_CONST = 6174;
    public static final int TEN_CONST = 10;
    public static final int ARRAY_SIZE = 4;
    public static final int MIN = 1000;
    public static final int MAX = 9999;

    private KaprekarConst() {

    }

    public static int countK(int n) {
        int num = n;
        if (num <= MIN || num > MAX) {
            throw new IllegalArgumentException("Wrong input");
        }
        if (num == K_CONST) {
            return 0;
        }
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; ++i) {
            arr[i] += num % TEN_CONST;
            num /= TEN_CONST;
        }
        int[] sortedArr = arr;
        Arrays.sort(arr);
        int[] minusArr = new int[ARRAY_SIZE];
        for (int i = 0; i < arr.length; i++) {
            minusArr[i] = -arr[i];
        }
        Arrays.sort(minusArr);
        int a = arrayToInt(sortedArr);
        int b = Math.abs(arrayToInt(minusArr));
        if (b == a) {
            throw new IllegalArgumentException("Same digits in the number");
        }
        int k = b - a;
        return countK(k) + 1;
    }

    private static int arrayToInt(int[] arr) {
        int num = 0;
        for (int d : arr) {
            num = TEN_CONST * num + d;
        }
        return num;
    }

}
