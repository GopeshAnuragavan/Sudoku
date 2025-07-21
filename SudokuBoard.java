// Gopesh Anuragavan
// CS 143
// HW: Sudoku #1, Core Topics: 2D arrays, File I/O, Classes
//
// This class defines the sudoku board and is responsible for storing the state
// of the 9x9 sudoku board. It loads the puzzle from a specific file and generates
// a string of the board. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuBoard {

    private int[][] board;
    
    // pre: The filePath parameter must be a valid path to the .sdk file. The file
    // must be 9x9 character grid where each chacter is '1-9' or '.' (empty cells).
    // post : Initializes the board by reading the puzzle data from the given file. 

    public SudokuBoard(String filePath){
        this.board = new int[9][9];
        
        try (Scanner scanner = new Scanner(new File(filePath))){
            for (int row = 0; row < 9; row++){
                if (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    for (int col = 0; col < 9; col++){
                        char cellChar = line.charAt(col);
                        if (cellChar == '.'){
                            this.board[row][col] = 0;
                        } else{
                            this.board[row][col] = Character.getNumericValue(cellChar);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.err.println("Error: File not found at path: " + filePath);
            e.printStackTrace();
        }
    }
    
    // pre: The board will be initialized.
    // post : Returns a formatted string representation of the sudoku board, with grid
    // lines to seperate the 3x3 sub-squares.
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++){
            if (row > 0 && row % 3 == 0){
                sb.append("------+-------+------\n");
            }
            for (int col = 0; col < 9; col++){
                if (col > 0 && col % 3 == 0){
                    sb.append("| ");
                }
                
                int cellValue = this.board[row][col];
                if (cellValue == 0){
                    sb.append(". ");
                } else{
                    sb.append(cellValue).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}