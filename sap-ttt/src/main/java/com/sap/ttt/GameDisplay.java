package com.sap.ttt;

import java.util.Scanner;

public class GameDisplay {
    public static Scanner scanner = new Scanner(System.in);

    // display welcome message
    public static void displayWelcomeMessage() {
        System.out.println("Welcome to Tic Tac Toe!");
    }

    // display player name prompt
    public static void displayPlayerNamePrompt() {
        System.out.println("Please enter your name: ");
    }

    // display player 2 name prompt
    public static void displayPlayer2NamePrompt() {
        System.out.println("Please enter the name of the second player: ");
    }

    // display player turn message
    public static void displayPlayerTurnMessage(String playerName) {
        System.out.println(playerName + "'s turn:");
    }

    public static int displayGameTypePrompt() {
        System.out.println("Please enter the game type:");
        System.out.println("1. Human vs Computer");
        System.out.println("2. Human vs Human");
        System.out.println("Your choice: ");
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

    // display board size prompt
    public static int displayBoardSizePrompt() {
        System.out.println("Please enter the board size:");
        System.out.println("1. Classic Board (3x3)");
        System.out.println("2. Big Board (10x10)");
        System.out.println("Your choice: ");
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

    // display wrong choice prompt
    public static void displayWrongChoicePrompt() {
        System.out.println("Wrong choice. Please try again.");
    }

    // display move prompt
    public static void displayMovePrompt() {
        System.out.println("Please enter your move: ");
    }


    // display invalid move prompt
    public static void displayInvalidMovePrompt() {
        System.out.println("Invalid move. Please enter a move in the format 'A1', 'B2', etc.");
    }

    // display end of game message
    public static void displayWinnerMessage(String winnerName) {
        System.out.println("Game over. " + winnerName + " won!");
    }

    // display draw message
    public static void displayDrawMessage() {
        System.out.println("Game over. It's a draw!");
    }

    // display play again prompt
    public static int displayPlayAgainPrompt() {
        System.out.println("Do you want to play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Your choice: ");
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

    // display goodbye message
    public static void displayGoodbyeMessage() {
        System.out.println("Thank you for playing Tic Tac Toe. Goodbye!");
    }
}
