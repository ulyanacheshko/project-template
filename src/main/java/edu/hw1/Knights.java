package edu.hw1;

public final class Knights {

    private Knights() {
    }

    private static final int[][] KNIGHTS_MOVES = {
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2},
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1},
    };
    private static final int SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        if (board.length != SIZE) {
            throw new IllegalArgumentException("Wrong width");
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[x].length != SIZE) {
                    throw new IllegalArgumentException("Wrong length");
                }
                if (board[x][y] == 1 && kill(x, y, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean kill(int x, int y, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int coord1 = KNIGHTS_MOVES[i][0] + x;
            int coord2 = KNIGHTS_MOVES[i][1] + y;
            if (coord1 >= 0 && coord2 >= 0 && coord1 < board.length && coord2 < board.length && board[coord2][coord1]
                == 1) {
                return true;
            }
        }
        return false;
    }
}
