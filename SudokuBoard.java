// Gopesh Anuragavan
// CS 143
// HW: Sudoku #2, Core Topics: 2D arrays, File I/O, Classes, Sets, Maps, Efficiency
//
// This class defines the sudoku board and is responsible for storing the state
// of the 9x9 sudoku board. It loads the puzzle from a specific file and generates
// a string of the board. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

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
    
//    pre: board must be initialized
//    post: returns true if board is valid and completely filled with numbers 1-9.
//    returns false otherwise.
    public boolean isSolved(){
      if(!isValid()){
         return false;
      }
      
      Map<Integer, Integer> counts = new HashMap<>();
      for(int r = 0; r < 9; r++){
         for(int c = 0; c < 9; c++){
            int value = board[r][c];
            if(value == 0){
               return false;
            }
            counts.put(value, counts.getOrDefault(value, 0)+1);
         }
      }
      
      for(int i = 1; i <= 9; i++){
         if(counts.getOrDefault(i, 0) != 9){
            return false;
         }
      }
      return true;
   }
   
//    pre: board must be initialized
//    post: returns true if board follows the rules, allows empty cells. Returns
//    false otherwise.
   public boolean isValid(){
      return hasValidData() && areRowsValid() && areColsValid() && areMiniSquaresValid();
   }
   
//    pre: board must be initialized
//    post: returns true if all cells contain numbers 1-9. Returns false if cell has value
//    outside this range
   private boolean hasValidData(){
      for(int r = 0; r < 9; r++){
         for(int c =0; c < 9; c++){
            int value = board[r][c];
            if(value < 0 || value > 9){
               return false;
            }
         }
      }
      return true;
   }
   
   //    pre: board must be initialized
   //    post: returns true if no row has duplicates, returns false otherwise
   private boolean areRowsValid(){
      for(int r = 0; r < 9; r++){
         Set<Integer> seen = new HashSet<>();
         for(int c = 0; c < 9; c++){
            int value = board[r][c];
            if(value != 0){
               if(!seen.add(value)){
                  return false;
               }
            }
         }
      }
      return true;
   }
   
   //    pre: board must be initialized
   //    post: returns true if columns have no duplicates, returns false otherwise
   private boolean areColsValid(){
      for(int c = 0; c < 9; c++){
         Set<Integer> seen = new HashSet<>();
         for(int r = 0; r < 9; r++){
            int value = board[r][c];
            if(value != 0){
               if(!seen.add(value)){
                  return false;
               }
            }
         }
      }
      return true;
   }
   
   //    pre: board must be initialized
   //    post: returns true if no 3x3 squares contain duplicates, returns false otherwise
   private boolean areMiniSquaresValid(){
      for(int spot = 1; spot <= 9; spot++){
         int[][] mini = miniSquare(spot);
         Set<Integer> seen = new HashSet<>();
         for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
               int value = mini[r][c];
               if(value != 0){
                  if(!seen.add(value)){
                     return false;
                  }
               }
            }
         }
      }
      return true;
   }
   
   //    pre: board must be initialized, and spot must have number 1-9
   //    post: returns 3x3 2d array representing mini square at given spot
   private int[][] miniSquare(int spot){
      int[][] mini = new int[3][3];
      for(int r =0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            mini[r][c] = board[(spot-1)/3*3 + r][(spot-1)%3*3 + c];
         }
      }
      return mini;
   }
}