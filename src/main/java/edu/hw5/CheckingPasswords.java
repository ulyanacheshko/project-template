package edu.hw5;

public class CheckingPasswords {
    private CheckingPasswords() {

    }

    public static boolean isPassword(String password) {
        String regex = ".*[~!@#$%^&*|].*";
        return password.matches(regex);
    }
}
