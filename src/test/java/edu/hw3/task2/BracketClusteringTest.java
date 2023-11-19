package edu.hw3.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw3.task2.BracketClustering.clusterize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BracketClusteringTest {

    private static Stream<Arguments> brackets() {
        return Stream.of(
            Arguments.of("()()()", new String[] {"()", "()", "()"}),
            Arguments.of("((()))", new String[] {"((()))"}),
            Arguments.of("((()))(())()()(()())", new String[] {"((()))", "(())", "()", "()", "(()())"}),
            Arguments.of("((())())(()(()()))", new String[] {"((())())", "(()(()()))"})
        );
    }

    @DisplayName("Тест clusterize")
    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("brackets")
    public void clusterizeTest(String input, String[] expected) {
        assertThat(clusterize(input).toArray()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Null тест")
    public void nullTest() {
        assertThatThrownBy(() -> clusterize(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
