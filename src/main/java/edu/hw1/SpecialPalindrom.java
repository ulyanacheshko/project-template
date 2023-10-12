package edu.hw1;

public class SpecialPalindrom {
    private static final int CONST_TEN = 10;

    private SpecialPalindrom() {

    }

    public static boolean isPalindromeDescendant(int n) {
        String str = String.valueOf(n);
        if (isPalindrome(str)) {
            return true;
        }
        while (str.length() != 0) {
            if (isPalindrome(str)) {
                return true;
            }
            str = getDescendants(str);
        }
        return false;
    }

    private static boolean isPalindrome(String str) {
        //String str = String.valueOf(n);
        int length = str.length();
        if (str.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < (length / 2); i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String getDescendants(String str) {
        StringBuilder descendant = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length - 1) {
            int first = Character.getNumericValue(charArray[i]);
            int second = Character.getNumericValue(charArray[i + 1]);
            int temp = first + second;
            descendant.append(temp);
            i += 2;
        }
        String descendantStr = descendant.toString();
        return descendantStr;
    }

    private static int countDigits(int a) {
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

