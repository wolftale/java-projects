package com.sap.ttt;

public class ClassicBoard extends Board {
    private static final int BOARD_SIZE = 3;

    @Override
    public int getBoardSize() {
        return BOARD_SIZE;
    }

    @Override
    public boolean checkWinner() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row][0] != ' ' && board[row][0] == board[row][1]
                    && board[row][1] == board[row][2]) {
                return true;
            }
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (board[0][col] != ' ' && board[0][col] == board[1][col]
                    && board[1][col] == board[2][col]) {
                return true;
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != ' ' && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    // New method for testing purposes
    public void setBoard(char[][] newBoard) {
        board = newBoard;
    }
}
