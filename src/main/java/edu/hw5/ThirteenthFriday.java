package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

public class ThirteenthFriday {
    private static final int THIRTEENTH_DAY = 13;
    private static final int ALL_MONTHS = 12;
    private static final int FRIDAY = 5;

    private ThirteenthFriday() {
    }

    protected static List<String> getDates(int year) {
        List<String> dates = new ArrayList<>();
        for (int month = 0; month < ALL_MONTHS; month++) {
            LocalDate date = LocalDate.of(year, month + 1, THIRTEENTH_DAY);
            if (date.getDayOfWeek().getValue() == FRIDAY) {
                dates.add(date.toString());
            }
        }
        return dates;
    }

    protected static LocalDate getNearestThirteenthFriday(LocalDate date) {
        TemporalAdjuster friday = java.time.temporal.TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY);
        LocalDate fridayDate = date.with(friday);
        int counter = 0;
        while (fridayDate.getDayOfMonth() != THIRTEENTH_DAY) {
            TemporalAdjuster nextFriday =
                java.time.temporal.TemporalAdjusters.dayOfWeekInMonth(counter, DayOfWeek.FRIDAY);
            fridayDate = date.with(nextFriday);
            counter++;
        }
        return fridayDate;
    }
}
