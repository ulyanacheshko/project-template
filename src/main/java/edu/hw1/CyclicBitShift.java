package edu.hw1;

public class CyclicBitShift {
    private CyclicBitShift() {

    }

    public static int rotateLeft(int n, int shift) {
        if (shift < 0 || n < 0) {
            throw new IllegalArgumentException("Wrong input in rotateLeft");
        }
        String binaryStr = Integer.toBinaryString(n);
        int length = binaryStr.length();
        int displacement = shift % length;
        String newBinaryStr = binaryStr.substring(displacement) + binaryStr.substring(0, displacement);
        return binaryToInt(newBinaryStr);
    }

    public static int rotateRight(int n, int shift) {
        if (shift < 0 || n < 0) {
            throw new IllegalArgumentException("Wrong input in rotateRight");
        }
        String binaryStr = Integer.toBinaryString(n);
        int length = binaryStr.length();
        int shiftMod = shift % length;
        int displacement = (length - shiftMod) % length;
        String newBinaryStr = binaryStr.substring(displacement) + binaryStr.substring(0, displacement);
        return binaryToInt(newBinaryStr);
    }

    static int binaryToInt(String binaryString) {
        int val = 0;
        for (char c : binaryString.toCharArray()) {
            val <<= 1;
            val += c - '0';
        }
        return val;
    }
}
