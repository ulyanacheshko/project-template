package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("MagicNumber")

public class MazeGenerator {

    private Maze maz;

    public MazeGenerator(Maze maz) {
        this.maz = maz;
    }

    public void generateMaze() {
        Random random = new Random();
        int width = maz.getWidth();
        int height = maz.getHeight();
        Cell[][] grid = maz.getGrid();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
        generatePaths(random, 0, 0);
        grid[0][0] = new Cell(0, 0, Cell.Type.START);
        grid[width - 1][height - 1] = new Cell(width - 1, height - 1, Cell.Type.END);
    }

    private void generatePaths(Random random, int row, int col) {
        Cell[][] grid = getMaze();
        grid[row][col] = new Cell(row, col, Cell.Type.PASSAGE);
        List<Integer> directions = new ArrayList<>(List.of(1, 2, 3, 4));
        java.util.Collections.shuffle(directions, random);
        for (int direction : directions) {

            if (direction == 1 && row > 1 && grid[row - 2][col].type() == Cell.Type.WALL) {
                grid[row - 1][col] = new Cell(row - 1, col, Cell.Type.PASSAGE);
                generatePaths(random, row - 2, col);
            }

            if (direction == 2 && row < maz.getWidth() - 2 && getMaze()[row + 2][col].type() == Cell.Type.WALL) {
                getMaze()[row + 1][col] = new Cell(row + 1, col, Cell.Type.PASSAGE);
                generatePaths(random, row + 2, col);
            }

            if (direction == 3 && col > 1 && getMaze()[row][col - 2].type() == Cell.Type.WALL) {
                getMaze()[row][col - 1] = new Cell(row, col - 1, Cell.Type.PASSAGE);
                generatePaths(random, row, col - 2);
            }

            if (direction == 4 && col < maz.getHeight() - 2 && getMaze()[row][col + 2].type() == Cell.Type.WALL) {
                getMaze()[row][col + 1] = new Cell(row, col + 1, Cell.Type.PASSAGE);
                generatePaths(random, row, col + 2);
            }
        }
    }

    public Cell[][] getMaze() {
        return maz.getGrid();
    }
}
