package com.sap.ttt;

//import java.util.Scanner;

public abstract class Board {
    protected char[][] board;
    public abstract boolean checkWinner();
    public abstract int getBoardSize();
//    private Scanner scanner;

    public void startBoard() {
        board = new char[getBoardSize()][getBoardSize()];
        for (int row = 0; row < getBoardSize(); row++) {
            for (int col = 0; col < getBoardSize(); col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println(getHeader());
        System.out.println(getHorizontalLine());

        for (int row = 0; row < getBoardSize(); row++) {
            String rowNum = String.format("%2d", row + 1); // Convert row number to a two-character string
            System.out.print(rowNum + " | ");
            for (int col = 0; col < getBoardSize(); col++) {
                char letter = (char) ('A' + col); // Convert column index to a letter
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n" + getHorizontalLine());
        }
    }

    // Get header
    public String getHeader() {
        StringBuilder header = new StringBuilder("     ");
        for (int col = 0; col < getBoardSize(); col++) {
            char letter = (char) ('A' + col);
            header.append(letter).append("   ");
        }
        return header.toString();
    }

    // Get horizontal line
    public String getHorizontalLine() {
        StringBuilder line = new StringBuilder("   +");
        for (int col = 0; col < getBoardSize(); col++) {
            line.append("---+");
        }
        return line.toString();
    }

    public boolean isMoveValid(int move) {
        if (move >= 1 && move <= getBoardSize() * getBoardSize()) {
            int row = (move - 1) / getBoardSize();
            int col = (move - 1) % getBoardSize();
            return (move >= 1 && move <= getBoardSize() * getBoardSize() && board[row][col] == ' ');
        } else {
            return false;
        }
    }

    public void makeMove(int move, char symbol) {
        if (move >= 1 && move <= getBoardSize() * getBoardSize()) {
            int row = (move - 1) / getBoardSize();
            int col = (move - 1) % getBoardSize();
            board[row][col] = symbol;

        }
    }

    public boolean isBoardFull() {
        for (int row = 0; row < getBoardSize(); row++) {
            for (int col = 0; col < getBoardSize(); col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
