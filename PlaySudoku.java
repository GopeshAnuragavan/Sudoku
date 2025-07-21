// Gopesh Anuragavan
// CS 143
// HW: Sudoku #1, Core Topics: 2D arrays, File I/O, Classes
//
// This program serves as a driver for SudokuBoard class. It initiates a SudokuBoard
// objeect using the given data file and then prints out the board.

public class PlaySudoku {

    public static void main(String[] args) {
        SudokuBoard puzzle = new SudokuBoard("data1-1-1.sdk");
        
        System.out.println("--- Sudoku Puzzle ---");
        System.out.println(puzzle);
    }
}

/*
Java Output
  ----jGRASP exec: java PlaySudoku
 --- Sudoku Puzzle ---
 2 . . | 1 . 5 | . . 3 
 . 5 4 | . . . | 7 1 . 
 . 1 . | 2 . 3 | . 8 . 
 ------+-------+------
 6 . 2 | 8 . 7 | 3 . 4 
 . . . | . . . | . . . 
 1 . 5 | 3 . 9 | 8 . 6 
 ------+-------+------
 . 2 . | 7 . 1 | . 6 . 
 . 8 1 | . . . | 2 4 . 
 7 . . | 4 . 2 | . . 1 
 
 
  ----jGRASP: Operation complete.


*/
