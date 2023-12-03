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
        DfsMazeGenerator dfsMazeGenerator = new DfsMazeGenerator(maz);
        dfsMazeGenerator.generateMaze();
        Cell[][] cell = dfsMazeGenerator.getMaze();
        Print.printMaze(cell);
        DfsMazeSolver dfsMazeSolver = new DfsMazeSolver(maz);
        dfsMazeSolver.solveMaze(cell);
        cell = dfsMazeSolver.getMaze();
        Print.printMaze(cell);
    }
}
