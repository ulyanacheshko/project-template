package edu.hw3.task7;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class NullComparatorTest {
    @org.junit.jupiter.api.Test
    public void nullComparator() {
        java.util.TreeMap<String, String> tree = new java.util.TreeMap<>(new NullComparator<>());
        tree.put(null, "test");
        tree.put("a", "test1");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
