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



































//    @Override
//    public int getMove(Board board) {
//    int depth = board.getBoardSize() == 10 ? 4 : 2; // Depth for the min-max algorithm
//    int[] bestMove = minimax(board, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true, getSymbol());
//    return bestMove[1];
//}
//
//    private int[] minimax(Board board, int depth, int alpha, int beta, boolean maximizingPlayer, char currentPlayerSymbol) {
//        if (depth == 0 || board.checkWinner() || board.isBoardFull()) {
//            int evaluation = evaluateBoard(board, currentPlayerSymbol);
//            return new int[]{evaluation, -1};
//        }
//
//        int bestMove = -1;
//        int bestValue = maximizingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//
//        int boardSize = board.getBoardSize();
//        for (int move = 1; move <= boardSize * boardSize; move++) {
//            if (board.isMoveValid(move)) {
//                char symbol = maximizingPlayer ? currentPlayerSymbol : (currentPlayerSymbol == 'X' ? 'O' : 'X');
//                board.makeMove(move, symbol);
//
//                int[] childValue = minimax(board, depth - 1, alpha, beta, !maximizingPlayer, currentPlayerSymbol);
//                int value = childValue[0];
//
//                if (maximizingPlayer && value > bestValue) {
//                    bestValue = value;
//                    bestMove = move;
//                    alpha = Math.max(alpha, bestValue);
//                } else if (!maximizingPlayer && value < bestValue) {
//                    bestValue = value;
//                    bestMove = move;
//                    beta = Math.min(beta, bestValue);
//                }
//
//                board.makeMove(move, ' '); // Undo the move
//
//                if (beta <= alpha) {
//                    break; // Alpha-beta pruning
//                }
//            }
//        }
//
//        return new int[]{bestValue, bestMove};
//    }
//
//
//    private int evaluateBoard(Board board, char currentPlayerSymbol) {
//        int score = 0;
//        final int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}}; //horizontal, vertical and the two diagonals
//        final int WIN_LENGTH = board.getBoardSize() == 10 ? 5 : 3; // WIN_LENGTH is 5 for a 10x10 board and 3 for a 3x3 board
//
//        int boardSize = board.getBoardSize();
//        char[][] gameBoard = board.board;
//
//        for (int row = 0; row < boardSize; row++) {
//            for (int col = 0; col < boardSize; col++) {
//                if (gameBoard[row][col] == currentPlayerSymbol) {
//                    for (int[] direction : directions) {
//                        int consecutiveCount = 1;
//                        int newRow = row + direction[0];
//                        int newCol = col + direction[1];
//                        while (consecutiveCount < WIN_LENGTH &&
//                                newRow >= 0 && newRow < boardSize &&
//                                newCol >= 0 && newCol < boardSize &&
//                                gameBoard[newRow][newCol] == currentPlayerSymbol) {
//                            consecutiveCount++;
//                            newRow += direction[0];
//                            newCol += direction[1];
//                        }
//                        if (consecutiveCount == WIN_LENGTH) {
//                            return Integer.MAX_VALUE; //winning condition; no need to check further
//                        }
//                        score += consecutiveCount; //score is the number of consecutive symbols
//                    }
//                } else if (gameBoard[row][col] != ' ') {
//                    for (int[] direction : directions) {
//                        int consecutiveCount = 1;
//                        int newRow = row + direction[0];
//                        int newCol = col + direction[1];
//                        while (consecutiveCount < WIN_LENGTH &&
//                                newRow >= 0 && newRow < boardSize &&
//                                newCol >= 0 && newCol < boardSize &&
//                                gameBoard[newRow][newCol] != currentPlayerSymbol &&
//                                gameBoard[newRow][newCol] != ' ') {
//                            consecutiveCount++;
//                            newRow += direction[0];
//                            newCol += direction[1];
//                        }
//                        if (consecutiveCount == WIN_LENGTH) {
//                            return Integer.MIN_VALUE; //losing condition; no need to check further
//                        }
//                        score += consecutiveCount * consecutiveCount; // for the current player
//                        score -= consecutiveCount * consecutiveCount; // for the opponent
//                    }
//                }
//            }
//        }
//        return score;
//    }
//}





