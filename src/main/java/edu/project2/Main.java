package edu.project2;

import java.util.Scanner;

@SuppressWarnings({"RegexpSinglelineJava"})

public class Main {
    private Main() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размеры лабиринта: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        Maze maz = new Maze(rows, cols, new Cell[rows][cols]);
        MazeGenerator mazeGenerator = new MazeGenerator(maz);
        mazeGenerator.generateMaze();
        Cell[][] cell = mazeGenerator.getMaze();
        Print.printMaze(cell);
        MazeSolve mazeSolver = new MazeSolve(maz);
        mazeSolver.solveMaze(cell);
        cell = mazeSolver.getMaze();
        Print.printMaze(cell);
    }
}
