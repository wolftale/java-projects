package com.sap.ttt;

import java.util.Scanner;

public class GameUI {

    // display welcome message
    public static void displayWelcomeMessage() {
        System.out.println("Welcome to Tic Tac Toe!");
    }

    // display player name
    public static void displayPlayerNamePrompt() {
        System.out.println("Please enter your name: ");
    }

    // display game menu
    public static int displayGameMenu() {
        System.out.println("Please choose board size:");
        System.out.println("1. 3x3");
        System.out.println("2. 10x10");
        System.out.println("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    // wrong choice
    public static void displayWrongChoiceMessage() {
        System.out.println("Wrong choice. Please try again.");
    }

    public static void displayEndGameMessage(String winnerName) {
        if (winnerName.equals("")) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Congratulations " + winnerName + "! You won!");
        }
    }

    public static void displayNewGamePrompt() {
        System.out.println("Do you want to play again? (n - new game, q - quit): ");
    }

    public static void displayMovePrompt(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + ", please enter your move (e.g. A1: ");
    }


    public static void displayInvalidMoveMessage() {
        System.out.println("Invalid move. Please try again.");
    }
}
