package edu.project2;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.project2.Cell.Type.*;
import static edu.project2.Cell.Type;

public class CellTest {

    public static Stream<Arguments> cellArguments() {
        return Stream.of(
            Arguments.of(-1, -1, WALL),
            Arguments.of(-10, 0, PASSAGE),
            Arguments.of(-10, -10, START)
        );
    }

    @ParameterizedTest
    @MethodSource("cellArguments")
    public void CellTest(int row, int column, Type type) {
        assertThrows(IllegalArgumentException.class, () -> new Cell(row, column, type));
    }
}
