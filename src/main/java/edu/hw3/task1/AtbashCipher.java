package edu.hw3.task1;

public class AtbashCipher {
    private AtbashCipher() {

    }

    public static String atbashCipher(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null string");
        }
        char[] strChar = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                strChar[i] = (char) ('Z' - (letter - 'A'));

            } else if (letter >= 'a' && letter <= 'z') {
                strChar[i] = (char) ('z' - (letter - 'a'));

            } else {
                strChar[i] = letter;
            }
        }
        String newStr = new String(strChar);
        return newStr;
    }
}
