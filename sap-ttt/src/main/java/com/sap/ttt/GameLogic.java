package com.sap.ttt;

import java.util.Scanner;

public class GameLogic {
    private Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Board board;
    private boolean playAgain = true;

    public void run() {
        GameDisplay.displayWelcomeMessage();

        while (playAgain) {
            setupGame();
            playGame();
            handlePlayAgain();
        }

        GameDisplay.displayGoodbyeMessage();
    }

    private void setupGame() {
        GameDisplay.displayPlayerNamePrompt();
        String playerName1 = scanner.nextLine();

        int gameType = GameDisplay.displayGameTypePrompt();

        if (gameType == 1) {
            player1 = new HumanPlayer('X', playerName1, board);
            player2 = new ComputerPlayer('O', "Computer", board);
        } else if (gameType == 2) {
            player2 = new HumanPlayer('O', playerName1, board);
            GameDisplay.displayPlayer2NamePrompt();
            String playerName2 = scanner.nextLine();
            player1 = new HumanPlayer('X', playerName2, board);
        } else {
            GameDisplay.displayWrongChoicePrompt();
            return;
        }

        int boardType = GameDisplay.displayBoardSizePrompt();

        if (boardType == 1) {
            board = new ClassicBoard();
        } else if (boardType == 2) {
            board = new BigBoard();
        } else {
            GameDisplay.displayWrongChoicePrompt();
            return;
        }

        board.startBoard();
    }

    private void playGame() {
        Player currentPlayer = player1;

        while (true) {
            board.displayBoard();
            int move = currentPlayer.getMove(board);
            board.makeMove(move, currentPlayer.getSymbol());

            if (board.checkWinner()) {
                board.displayBoard();
                GameDisplay.displayWinnerMessage(currentPlayer.getName());
                break;
            } else if (board.isBoardFull()) {
                board.displayBoard();
                GameDisplay.displayDrawMessage();
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private void handlePlayAgain() {
        int playAgainChoice = GameDisplay.displayPlayAgainPrompt();

        if (playAgainChoice == 1) {
            playAgain = true;
        } else if (playAgainChoice == 2) {
            playAgain = false;
        } else {
            GameDisplay.displayWrongChoicePrompt();
            handlePlayAgain();
        }

        if (!playAgain) {
            scanner.close(); // Close the scanner before displaying the goodbye message
        }
    }
}
