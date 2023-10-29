package edu.hw3.task2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BracketClustering {
    private BracketClustering() {

    }

    public static List<String> clusterize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Null input");
        }
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        List<String> output = new ArrayList<>();
        int count = 0;
        int start = 0;
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (brackets.containsValue(c)) {
                count++;
            } else if (brackets.containsKey(c)) {
                count--;
                if (count == 0) {
                    output.add(input.substring(start, i + 1));
                    start = i + 1;
                }
            }
        }
        return output;
    }
}
