package edu.hw5;

public class RegexAdditionalTask {
    private RegexAdditionalTask() {

    }

    public static boolean isOddLength(String input) {
        String regex = "[01]([01]{2})*";
        return input.matches(regex);
    }

    public static boolean isZeroOddOrOneEvenLength(String input) {
        String regex = "0([01]{2})*|1[01]([01]{2})*";
        return input.matches(regex);
    }

    public static boolean isNotTwoOrThreeOnes(String input) {
        String regex = "(?!11|111$)[01]*";
        return input.matches(regex);
    }

    public static boolean isEveryOddSymbolIsOne(String string) {
        return string.matches("(1[01])*1?");
    }

    public static boolean noConsisteveOnes(String string) {
        return string.matches("(?!.*11)(^[01]*$)");
    }

}

