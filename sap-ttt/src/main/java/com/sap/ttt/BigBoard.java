package com.sap.ttt;

public class BigBoard extends Board {
    private static final int BOARD_SIZE = 10;
    private static final int WIN_LENGTH = 5;

    @Override
    public int getBoardSize() {
        return BOARD_SIZE;
    }

    @Override
    public boolean checkWinner() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE - WIN_LENGTH + 1; col++) {
                if (board[row][col] != ' ' && board[row][col] == board[row][col + 1]
                        && board[row][col + 1] == board[row][col + 2]
                        && board[row][col + 2] == board[row][col + 3]
                        && board[row][col + 3] == board[row][col + 4]) {
                    return true;
                }
            }
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = 0; row < BOARD_SIZE - WIN_LENGTH + 1; row++) {
                if (board[row][col] != ' ' && board[row][col] == board[row + 1][col]
                        && board[row + 1][col] == board[row + 2][col]
                        && board[row + 2][col] == board[row + 3][col]
                        && board[row + 3][col] == board[row + 4][col]) {
                    return true;
                }
            }
        }

        for (int row = 0; row < BOARD_SIZE - WIN_LENGTH + 1; row++) {
            for (int col = 0; col < BOARD_SIZE - WIN_LENGTH + 1; col++) {
                if (board[row][col] != ' ' && board[row][col] == board[row + 1][col + 1]
                        && board[row + 1][col + 1] == board[row + 2][col + 2]
                        && board[row + 2][col + 2] == board[row + 3][col + 3]
                        && board[row + 3][col + 3] == board[row + 4][col + 4]) {
                    return true;
                }
            }
        }

        for (int row = 0; row < BOARD_SIZE - WIN_LENGTH + 1; row++) {
            for (int col = WIN_LENGTH - 1; col < BOARD_SIZE; col++) {
                if (board[row][col] != ' ' && board[row][col] == board[row + 1][col - 1]
                        && board[row + 1][col - 1] == board[row + 2][col - 2]
                        && board[row + 2][col - 2] == board[row + 3][col - 3]
                        && board[row + 3][col - 3] == board[row + 4][col - 4]) {
                    return true;
                }
            }
        }
        return false;
    }
}