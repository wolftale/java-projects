package com.sap.ttt;

import java.util.Scanner;

public class GameLogic {
    private Scanner scanner;
    private Player player1;
    private Player player2;
    private Board board;
    private boolean playAgain;

    public GameLogic() {
        scanner = new Scanner(System.in);
        playAgain = true;
    }

    public void run() {
        GameDisplay.displayWelcomeMessage();

        while (playAgain) {
            setupGame();
            playGame();
            handlePlayAgain();
        }

        // Display goodbye message after the play again loop
        GameDisplay.displayGoodbyeMessage();
    }

    private void setupGame() {
        // Ask for player's name only once
        GameDisplay.displayPlayerNamePrompt();
        String playerName1 = scanner.nextLine();
        String playerName2 = null;

        int gameType = GameDisplay.displayGameTypePrompt();

        if (gameType == 1) {
            player1 = new HumanPlayer('X', playerName1, board);
            player2 = new ComputerPlayer('O', "Computer", board);
        } else if (gameType == 2) {
            player2 = new HumanPlayer('O', playerName1, board);
            if (playerName2 == null) {
                GameDisplay.displayPlayer2NamePrompt();
                playerName2 = scanner.nextLine();
            }
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
            GameDisplay.displayPlayerTurnMessage(currentPlayer.getName());
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
            return;
        }

        // Close the scanner before displaying the goodbye message
        if (!playAgain) {
            scanner.close();
        }
    }
}

