package edu.hw1;

public final class BrokenString {

    private BrokenString() {

    }

    public static String fixString(String brokenStr) {
        int length = brokenStr.length();
        if (length == 0) {
            return " ";
        }
        char[] brokenStrChar = brokenStr.toCharArray();
        int i = 0;
        while (i < length - 1) {
            char temp = brokenStrChar[i];
            brokenStrChar[i] = brokenStrChar[i + 1];
            brokenStrChar[i + 1] = temp;
            i += 2;
        }
        return String.copyValueOf(brokenStrChar);
    }

}
