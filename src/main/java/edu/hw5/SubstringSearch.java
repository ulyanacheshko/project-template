package edu.hw5;

public class SubstringSearch {
    private SubstringSearch() {

    }

    public static boolean findSubstring(String str, String subStr) {
        String regex = ".*" + subStr + ".*";
        return str.matches(regex);
    }
}
