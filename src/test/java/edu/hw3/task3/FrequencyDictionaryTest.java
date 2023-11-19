package edu.hw3.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import static edu.hw3.task3.FrequencyDictionary.freqDict;

class FrequencyDictionaryTest {

    @Test
    @DisplayName("Словарь со строками")
    void freqDictString() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("bb");
        list.add("a");
        list.add("bb");
        Map<String, Integer> expected = new HashMap<>() {{
            put("a", 2);
            put("bb", 2);
        }};
        Map<String, Integer> response = freqDict(list);
        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Словарь с числами")
    void freqDictInt() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        Map<Integer, Integer> expected = new HashMap<>() {{
            put(1, 2);
            put(2, 2);
        }};
        Map<Integer, Integer> response = freqDict(list);
        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Словарь с символами")
    void freqDictCharacter() {
        List<Character> list = new ArrayList<Character>();
        list.add('s');
        list.add('s');
        list.add('l');
        list.add('l');
        list.add('l');
        Map<Character, Integer> expected = new HashMap<>() {{
            put('s', 2);
            put('l', 3);
        }};
        Map<Character, Integer> response = freqDict(list);
        assertThat(response).isEqualTo(expected);
    }

}
