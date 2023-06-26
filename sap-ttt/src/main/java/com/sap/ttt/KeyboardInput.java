package com.sap.ttt;

import java.util.Scanner;

public class KeyboardInput {

    // create method to read input from readKey() reads a single character from the keyboard and returns it

    public static char readKey() {

        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }
}
