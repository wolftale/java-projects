package com.sap.ttt;

public class Board {

    private int size;
    private char[][] cells;

    public Board(int size) {
        this.size = size;
        cells = new char[size][size];
        initializeBoard();
    }

    public void setSize(int size) {
        this.size = size;
        cells = new char[size][size];
        initializeBoard();
    }

    // initialize the board with all empty cells
    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    // check if the cell is empty
    public boolean isCellEmpty(int row, int col) {
        return cells[row][col] == ' ';
    }

    // check if the cell is occupied
    public boolean isCellOccupied(int row, int col) {
        return cells[row][col] != ' ';
    }

    // place the symbol in the cell
    public void placeSymbol(int row, int col, char symbol) {
        cells[row][col] = symbol;
    }

    // isWinningMove
    public boolean isWinningMove(int row, int col, char symbol) {
        return checkRows(row, col, symbol) || checkColumns(row, col, symbol) || checkDiagonals(row, col, symbol);
    }

    // check if the row is winning
    public boolean checkRows(int row, int col, char symbol) {
        for (int i = 0; i < size; i++) {
            if (cells[row][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    // check if the column is winning
    public boolean checkColumns(int row, int col, char symbol) {
        for (int i = 0; i < size; i++) {
            if (cells[i][col] != symbol) {
                return false;
            }
        }
        return true;
    }


    // check if the diagonal is winning
    public boolean checkDiagonals(int row, int col, char symbol) {
        if (row == col) {
            for (int i = 0; i < size; i++) {
                if (cells[i][i] != symbol) {
                    return false;
                }
            }
            return true;
        } else if (row + col == size - 1) {
            for (int i = 0; i < size; i++) {
                if (cells[i][size - i - 1] != symbol) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    // print the board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j] + " ");
                if (j != size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    if (j != size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}
