package com.sap.ttt;

public interface Player {
    char getSymbol();
    int getMove(Board board);
    String getName();
}
