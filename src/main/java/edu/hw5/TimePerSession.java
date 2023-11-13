package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimePerSession {

    private static final DateTimeFormatter DATA_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    private TimePerSession() {

    }

    public static String getAverageDuration(List<String> visitDates) {
        Duration allDuration = Duration.ZERO;
        List<Duration> durations = visitDates.stream().map(input -> {
            try {
                return getDuration(input);
            } catch (java.text.ParseException e) {
                throw new RuntimeException(e);
            }
        }).toList();
        for (Duration duration : durations) {
            allDuration = allDuration.plus(duration);
        }
        Duration average = allDuration.dividedBy(durations.size());
        String output = average.toHours() + "ч " + average.toMinutesPart() + "м";
        return output;
    }

    private static Duration getDuration(String input) throws java.text.ParseException {
        String[] str = input.split(" - ");
        LocalDateTime from = LocalDateTime.parse(str[0], DATA_TIME);
        LocalDateTime to = LocalDateTime.parse(str[1], DATA_TIME);
        Duration duration = Duration.between(from, to);
        return duration;
    }
}
