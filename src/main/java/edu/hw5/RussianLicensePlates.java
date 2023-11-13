package edu.hw5;

public class RussianLicensePlates {
    private RussianLicensePlates() {

    }

    public static boolean isLicensePlates(String password) {
        String regex = "[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}";
        return password.matches(regex);
    }
}
