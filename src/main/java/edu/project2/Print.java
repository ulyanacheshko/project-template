package edu.project2;

@SuppressWarnings({"RegexpSinglelineJava"})

public class Print {
    private Print() {

    }

    public static void printMaze(Cell[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j].type() == Cell.Type.WALL) {
                    System.out.print("⬛");
                } else if (maze[i][j].type() == Cell.Type.SOLVE) {
                    System.out.print("\uD83D\uDFE9");
                } else if (maze[i][j].type() == Cell.Type.START) {
                    System.out.print("\uD83D\uDFE8");
                } else if (maze[i][j].type() == Cell.Type.END) {
                    System.out.print("\uD83D\uDFE5");
                } else {
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
        System.out.println(" ");
    }
}
