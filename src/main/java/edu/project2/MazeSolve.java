package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static edu.project2.Cell.Type.END;
import static edu.project2.Cell.Type.PASSAGE;
import static edu.project2.Cell.Type.SOLVE;
import static edu.project2.Cell.Type.START;

public class MazeSolve {
    private Maze maz;

    public MazeSolve(Maze maz) {
        this.maz = maz;
    }

    public List<Coordinate> solveMaze(Cell[][] grid) {
        List<Coordinate> answer = new ArrayList<>();
        Stack<Cell> stack = new Stack<>();
        stack.push(grid[0][0]);

        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            int row = current.row();
            int col = current.col();

            int rows = maz.getWidth();
            int cols = maz.getHeight();

            if (grid[row][col].type() == END) {
                break;
            }

            if (grid[row][col].type() != START) {
                grid[row][col] = new Cell(row, col, SOLVE);
                answer.add(new Coordinate(row, col));
            }

            if (row > 0 && (grid[row - 1][col].type() == PASSAGE || grid[row - 1][col].type() == END)) {
                stack.push(grid[row - 1][col]);
            }

            if (row < rows - 1 && (grid[row + 1][col].type() == PASSAGE || grid[row + 1][col].type() == END)) {
                stack.push(grid[row + 1][col]);
            }

            if (col > 0 && (grid[row][col - 1].type() == PASSAGE || grid[row][col - 1].type() == END)) {
                stack.push(grid[row][col - 1]);
            }

            if (col < cols - 1 && (grid[row][col + 1].type() == PASSAGE || grid[row][col + 1].type() == END)) {
                stack.push(grid[row][col + 1]);
            }
        }
        return answer;
    }

    public Cell[][] getMaze() {
        return maz.getGrid();
    }
}
