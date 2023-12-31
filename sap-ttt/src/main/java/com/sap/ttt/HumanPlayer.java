package com.sap.ttt;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final char symbol;
    private final String name;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(char symbol, String name, Board board) {
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getMove(Board board) {
        int move = -1;
        boolean validMove = false;
        int boardSize = getBoardSize(board);

        while (!validMove) {
            GameDisplay.displayMovePrompt();
            String input = scanner.nextLine().trim().toUpperCase();

            // Check if the input has at least two characters
            if (input.length() >= 2) {
                char colChar = input.charAt(0);
                char rowChar = input.charAt(1);

                // Check if the first character is a letter and the second character is a digit
                if (Character.isLetter(colChar) && Character.isDigit(rowChar)) {
                    int col = colChar - 'A';
                    int row = rowChar - '1';

                    // If there are more digits, continue parsing
                    if (input.length() > 2) {
                        row = Integer.parseInt(input.substring(1)) - 1;
                    }

                    if (col >= 0 && col < boardSize && row >= 0 && row < boardSize) {
                        move = row * boardSize + col + 1;
                        validMove = board.isMoveValid(move);
                    }
                }

                if (!validMove) {
                    GameDisplay.displayInvalidMovePrompt();
                }
            }
        }
        return move;
    }

    private int getBoardSize(Board board) {
        if (board instanceof BigBoard) {
            return board.getBoardSize();
        } else if (board instanceof ClassicBoard) {
            return board.getBoardSize();
        }
        return 0;
    }
}