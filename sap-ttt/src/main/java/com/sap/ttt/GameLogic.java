package com.sap.ttt;

import java.util.Scanner;

public class GameLogic {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private boolean gameRunning;

    public GameLogic() {
        player1 = null;
        player2 = null;
        currentPlayer = null;
        board = null;
        gameRunning = false;
    }

    public void initializeGame() {
        Scanner scanner = new Scanner(System.in);
        GameUI.displayPlayerNamePrompt();
        String name = scanner.nextLine();
        player1 = new Player(name, 'X');

        int choice = GameUI.displayGameMenu();
        while (choice != 1 && choice != 2) {
            GameUI.displayWrongChoiceMessage();
            choice = GameUI.displayGameMenu();
        }

        if (choice == 1) {
            board = new Board(3);
        } else if (choice == 2) {
            board = new Board(10);
        }

        currentPlayer = player1;
        player2 = new Player("Computer", 'O'); // Przykład dla gry z komputerem

        gameRunning = true;
    }

    public void switchPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void makeMove() {
        GameUI.displayMovePrompt(currentPlayer);

        int row = -1;
        int col = -1;

        // Pobranie ruchu od gracza
        boolean validMove = false;
        while (!validMove) {
            char input = KeyboardInput.readKey();

            // Konwersja współrzędnych (np. A1) na indeksy w tablicy
            col = Character.toUpperCase(input) - 'A';
            row = KeyboardInput.readKey() - '1';

            if (row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize()) {
                if (board.isCellEmpty(row, col)) {
                    validMove = true;
                } else {
                    GameUI.displayInvalidMoveMessage();
                }
            } else {
                GameUI.displayInvalidMoveMessage();
            }
        }

        board.placeSymbol(row, col, currentPlayer.getSymbol());
    }

    public void checkGameStatus() {

        int row = -1;
        int col = -1;

        boolean isWin = board.isWinningMove(row, col, currentPlayer.getSymbol());
        boolean isDraw = board.isBoardFull() && !isWin;

        if (isWin || isDraw) {
            GameUI.displayEndGameMessage(isWin ? currentPlayer.getName() : "");
            gameRunning = false;
        } else {
            switchPlayers();
        }
    }

    public void run() {
        GameUI.displayWelcomeMessage();
        initializeGame();

        while (gameRunning) {
            board.printBoard();
            makeMove();
            checkGameStatus();
        }

        GameUI.displayNewGamePrompt();
        char choice = KeyboardInput.readKey();
        if (choice == 'n') {
            run();
        }
    }
}
