package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyDictionary<T> {
    private FrequencyDictionary() {

    }

    public static <T> Map<T, Integer> freqDict(List<T> lines) {
        Map<T, Integer> map = new HashMap<>();
        for (T i : lines) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

}
