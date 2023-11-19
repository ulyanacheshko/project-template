package edu.project3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class Utils {
    private HttpStatuses httpStatuses;

    Utils() {
        httpStatuses = new HttpStatuses();
    }

    public static Map<String, Integer> getRequestResource(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::requestResource, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(logs.size())
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static Map<String, Integer> getStatusCode(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::statusCode, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(logs.size())
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static Map<String, Integer> getIpAddresses(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::remoteAddress, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(logs.size())
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static Map<String, Integer> getRequestTypes(List<Log> logs) {
        return logs.stream()
            .collect(Collectors.groupingBy(Log::requestType, Collectors.summingInt(t -> 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(logs.size())
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static double getAverageBytesResponse(List<Log> logs) {
        return logs.stream().mapToDouble(Log::bodyBytesSend).sum() / logs.size();
    }

}
