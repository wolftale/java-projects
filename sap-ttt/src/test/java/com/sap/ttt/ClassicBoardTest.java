package com.sap.ttt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClassicBoardTest {

    @Test
    public void testCheckWinner_O_WinningRows() {
        // Given
        ClassicBoard board = new ClassicBoard();
        board.setBoard(new char[][]{
                {'O', 'O', 'O'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        });

        // When
        boolean result = board.checkWinner();

        // Then
        assertTrue(result);
    }

    @Test
    public void testCheckWinner_O_WinningColumns() {
        // Given
        ClassicBoard board = new ClassicBoard();
        board.setBoard(new char[][]{
                {'O', ' ', ' '},
                {'O', ' ', ' '},
                {'O', ' ', ' '}
        });

        // When
        boolean result = board.checkWinner();

        // Then
        assertTrue(result);
    }

    @Test
    public void testCheckWinner_O_WinningDiagonal() {
        // Given
        ClassicBoard board = new ClassicBoard();
        board.setBoard(new char[][]{
                {'O', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', 'O'}
        });

        // When
        boolean result = board.checkWinner();

        // Then
        assertTrue(result);
    }

    @Test
    public void testCheckWinner_X_WinningRows() {
        // Given
        ClassicBoard board = new ClassicBoard();
        board.setBoard(new char[][]{
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        });

        // When
        boolean result = board.checkWinner();

        // Then
        assertTrue(result);
    }

    @Test
    public void testCheckWinner_X_WinningColumns() {
        // Given
        ClassicBoard board = new ClassicBoard();
        board.setBoard(new char[][]{
                {'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}
        });

        // When
        boolean result = board.checkWinner();

        // Then
        assertTrue(result);
    }

    @Test
    public void testCheckWinner_X_WinningDiagonal() {
        // Given
        ClassicBoard board = new ClassicBoard();
        board.setBoard(new char[][]{
                {'X', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', 'X'}
        });

        // When
        boolean result = board.checkWinner();

        // Then
        assertTrue(result);
    }

    @Test
    public void testCheckWinner_Draw() {
        // Given
        ClassicBoard board = new ClassicBoard();
        board.setBoard(new char[][]{
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        });

        // When
        boolean result = board.checkWinner();

        // Then
        assertFalse(result);
    }
}




//    private ClassicBoard classicBoard;
//
//    @BeforeEach
//    public void setup() {
//        classicBoard = new ClassicBoard();
//    }
//
//    @Test
//    public void testCheckWinner_RowWin() {
//        classicBoard.startBoard();
//        classicBoard.makeMove(1, 'X');
//        classicBoard.makeMove(2, 'X');
//        classicBoard.makeMove(3, 'X');
//
//        assertTrue(classicBoard.checkWinner());
//    }
//
//    @Test
//    public void testCheckWinner_ColumnWin() {
//        classicBoard.startBoard();
//        classicBoard.makeMove(1, 'O');
//        classicBoard.makeMove(4, 'O');
//        classicBoard.makeMove(7, 'O');
//
//        assertTrue(classicBoard.checkWinner());
//    }
//
//    @Test
//    public void testCheckWinner_DiagonalWin() {
//        classicBoard.startBoard();
//        classicBoard.makeMove(1, 'X');
//        classicBoard.makeMove(5, 'X');
//        classicBoard.makeMove(9, 'X');
//
//        assertTrue(classicBoard.checkWinner());
//    }
//
//    @Test
//    public void testCheckWinner_OtherDiagonalWin() {
//        classicBoard.startBoard();
//        classicBoard.makeMove(3, 'O');
//        classicBoard.makeMove(5, 'O');
//        classicBoard.makeMove(7, 'O');
//
//        assertTrue(classicBoard.checkWinner());
//    }
//
//    @Test
//    public void testCheckWinner_NoWinner() {
//        classicBoard.startBoard();
//        classicBoard.makeMove(1, 'X');
//        classicBoard.makeMove(5, 'O');
//        classicBoard.makeMove(9, 'X');
//
//        assertFalse(classicBoard.checkWinner());
//    }
//}
