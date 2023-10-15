package edu.hw1;

public class NestedArray {
    private NestedArray() {

    }

    public static boolean isNestable(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input is null");
        }
        boolean n = false;
        int aMin = arrayMin(a);
        int aMax = arrayMax(a);
        int bMin = arrayMin(b);
        int bMax = arrayMax(b);
        if (aMin > bMin && aMax < bMax) {
            n = true;
        }
        return n;
    }

    private static int arrayMin(int[] nums) {
        int min = nums[0];
        for (int i : nums) {
            min = Math.min(i, min);
        }
        return min;
    }

    private static int arrayMax(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(i, max);
        }
        return max;
    }

}
