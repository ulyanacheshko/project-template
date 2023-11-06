package edu.hw3.task4;

import java.util.HashMap;

public class RomanNumerals {

    @SuppressWarnings("MagicNumber")

    private static final HashMap<Integer, String> h = new HashMap<Integer, String>();
    static String intToRoman(int input) {
        int num = input;
        if (num < 0 || num > 3999) {
            throw new IllegalArgumentException("Incorrect input");
        }
        if (num == 0) {
            return "N";
        }
        h.put(1, "I");
        h.put(4, "IV");
        h.put(5, "V");
        h.put(9, "IX");
        h.put(10, "X");
        h.put(40, "XL");
        h.put(50, "L");
        h.put(90, "XC");
        h.put(100, "C");
        h.put(400, "CD");
        h.put(500, "D");
        h.put(900, "CM");
        h.put(1000, "M");

        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String s = "";

        for (int i : arr) {
            while (num >= i) {
                s += h.get(i);
                num -= i;
            }
        }
        return s;
    }
}
