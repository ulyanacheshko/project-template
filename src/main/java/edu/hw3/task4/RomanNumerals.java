package edu.hw3.task4;

import java.util.HashMap;

public class RomanNumerals {
    private RomanNumerals() {

    }

    private static final HashMap<Integer, String> H_MAP = new HashMap<Integer, String>();

    @SuppressWarnings("MagicNumber")
    static String intToRoman(int input) {
        int num = input;
        if (num < 0 || num > 3999) {
            throw new IllegalArgumentException("Incorrect input");
        }
        if (num == 0) {
            return "N";
        }
        H_MAP.put(1, "I");
        H_MAP.put(4, "IV");
        H_MAP.put(5, "V");
        H_MAP.put(9, "IX");
        H_MAP.put(10, "X");
        H_MAP.put(40, "XL");
        H_MAP.put(50, "L");
        H_MAP.put(90, "XC");
        H_MAP.put(100, "C");
        H_MAP.put(400, "CD");
        H_MAP.put(500, "D");
        H_MAP.put(900, "CM");
        H_MAP.put(1000, "M");

        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String s = "";

        for (int i : arr) {
            while (num >= i) {
                s += H_MAP.get(i);
                num -= i;
            }
        }
        return s;
    }
}
