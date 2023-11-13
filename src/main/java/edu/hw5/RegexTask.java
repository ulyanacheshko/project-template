package edu.hw5;

public class RegexTask {
    private RegexTask() {

    }

    public static boolean atLeastTreeCharacters(String input) {
        String regex = "[01]{2}0[01]*";
        return input.matches(regex);
    }

    public static boolean beginAndEndSame(String input) {
        String regex = "^(0|1)[01]*\\1$";
        return input.matches(regex);
    }

    public static boolean moreOneAndLessThree(String string) {
        return string.matches("[01]{1,3}");
    }

}
