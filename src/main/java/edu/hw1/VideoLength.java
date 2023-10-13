package edu.hw1;

public class VideoLength {

    private static final int MAX_SEC = 60;

    private VideoLength() {
    }

    public static int minutesToSeconds(String time) {
        int n = 0;
        String[] str = time.split(":");
        int[] num = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }

        if (num[1] >= MAX_SEC) {
            return -1;
        }
        n = num[0] * MAX_SEC + num[1];
        return n;
    }

}
