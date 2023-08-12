package com.sap.ttt;

public class ComputerPlayer implements Player {
    private final char symbol;
    private final String name;
    private final Board board;

    public ComputerPlayer(char symbol, String name, Board board) {
        this.symbol = symbol;
        this.name = name;
        this.board = board;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public int getMove(Board board) {
        int boardSize = board.getBoardSize();
        int move = -1;

        // Generate random moves until a valid move is found
        while (move == -1) {
            int randomCell = (int) (Math.random() * boardSize * boardSize) + 1;
            if (board.isMoveValid(randomCell)) {
                move = randomCell;
            }
        }

        return move;
    }
}
