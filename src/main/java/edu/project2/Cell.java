package edu.project2;

public record Cell(int row, int col, Type type) {

    public Cell(int row, int col, Type type) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Illegal arguments");
        }
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public enum Type { WALL, PASSAGE, SOLVE, START, END }
}
