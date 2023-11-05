package edu.project2;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MazeSolveTest {
    protected static Stream<Arguments> mazes() {

        Maze maz1 = new Maze(13, 13, new Cell[13][13]);
        Maze maz2 = new Maze(11, 11, new Cell[11][11]);
        Maze maz3 = new Maze(15, 15, new Cell[15][15]);

        return Stream.of(
            Arguments.of(maz1),
            Arguments.of(maz2),
            Arguments.of(maz3)
        );
    }

    protected boolean isSolved(Maze maz) {
        MazeGenerator mazeGenerator = new MazeGenerator(maz);
        mazeGenerator.generateMaze();
        MazeSolve mazeSolver = new MazeSolve(maz);
        mazeSolver.solveMaze(maz.getGrid());
        Cell[][] grid = maz.getGrid();

        return grid.length != 0;
    }

    @DisplayName("Cоздание проходимого лабиринта")
    @ParameterizedTest()
    @MethodSource("mazes")
    public void mazeSolvedTest(Maze maz) {
        Assertions.assertThat(isSolved(maz)).isTrue();
    }

}
