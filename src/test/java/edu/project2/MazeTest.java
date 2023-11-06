package edu.project2;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class MazeTest {

    public static Stream<Arguments> mazes() {
        return Stream.of(
            Arguments.of(-1, -1, new Cell[][] {}),
            Arguments.of(0, 0, new Cell[][] {}),
            Arguments.of(1, 1, new Cell[][] {})
        );
    }

    @ParameterizedTest
    @MethodSource("mazes")
    public void WrongInputTest(int rows, int col, Cell[][] grid) {
        assertThrows(IllegalArgumentException.class, () -> new Maze(rows, col, grid));
    }
}
