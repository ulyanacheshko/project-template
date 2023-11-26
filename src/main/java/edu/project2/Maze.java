package edu.project2;

public class Maze {
    private final int width;
    private final int height;
    private final Cell[][] grid;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    protected Maze(int width, int height, Cell[][] grid) {
        if (width <= 2 || height <= 2) {
            throw new IllegalArgumentException("The dimension of the maze must be greater than 2");
        }
        this.width = width;
        this.height = height;
        this.grid = grid;
    }
}
