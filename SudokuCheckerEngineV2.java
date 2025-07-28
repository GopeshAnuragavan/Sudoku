// Gopesh Anuragavan
// CS 143
// HW: Sudoku #2, Core Topics: 2D arrays, File I/O, Classes, Sets, Maps, Efficiency
//
// This program acts as a test engine for SudokuBoard class. It creates several SudokuBoard
// objects using various data files and runs several tests to test functionality of isValid()
// and isSolved().
public class SudokuCheckerEngineV2 {

// pre: SudokuBoard must be compiled and accessible. "boards" subfolder with all .sdk
// files must exist in the same folder as the engine.
// post: prints result of each test to the console, a final success message is given
// if all tests pass.
   public static void main(String[] args) {
      // Note that here I am calling the board object SudokuBoard
      // if you named your class something different, you should
      // find and replace all `SudokuBoard` with your class name
      boolean allTests = true;
      
      // an empty board is valid, but not solved
      System.out.print("Checking empty board...");
      SudokuBoard board1 = new SudokuBoard("boards/empty.sdk");
      assert board1.isValid() : "isValid: should be true";
      assert !board1.isSolved() : "isSolved: should be false";
      if(board1.isValid() && !board1.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }
   
      // an incomplete, valid board is valid, but not solved
      System.out.print("Checking incomplete, valid board...");
      SudokuBoard board2 = new SudokuBoard("boards/valid-incomplete.sdk");
      assert board2.isValid() : "isValid: should be true";
      assert !board2.isSolved() : "isSolved: should be false";
      if(board2.isValid() && !board2.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }
      
      // a complete, valid board is valid and solved
      System.out.print("Checking complete, valid board...");
      SudokuBoard board3 = new SudokuBoard("boards/valid-complete.sdk");
      assert board3.isValid() : "isValid: should be true";
      assert board3.isSolved() : "isSolved: should be true";
      if(board3.isValid() && board3.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }
      
      // a board with dirty data is not valid and not solved
      System.out.print("Checking dirty data board...");
      SudokuBoard board4 = new SudokuBoard("boards/dirty-data.sdk");
      assert !board4.isValid() : "isValid: should be false";
      assert !board4.isSolved() : "isSolved: should be false";
      if(!board4.isValid() && !board4.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }
      
      // a board with a row violation is not valid and not solved
      System.out.print("Checking row violating board...");
      SudokuBoard board5 = new SudokuBoard("boards/row-violation.sdk");
      assert !board5.isValid() : "isValid: should be false";
      assert !board5.isSolved() : "isSolved: should be false";
      if(!board5.isValid() && !board5.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }
      
      // a board with a column violation is not valid and not solved
      System.out.print("Checking col violating board...");
      SudokuBoard board6 = new SudokuBoard("boards/col-violation.sdk");
      assert !board6.isValid() : "isValid: should be false";
      assert !board6.isSolved() : "isSolved: should be false";
      if(!board6.isValid() && !board6.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }
      
      // a board with both a row and a column violation is not valid and not solved
      System.out.print("Checking row&col violating board...");
      SudokuBoard board7 = new SudokuBoard("boards/row-and-col-violation.sdk");
      assert !board7.isValid() : "isValid: should be false";
      assert !board7.isSolved() : "isSolved: should be false";
      if(!board7.isValid() && !board7.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }
      
      // a board with a mini-square violation is not valid and not solved
      System.out.print("Checking mini-square violating board...");
      SudokuBoard board8 = new SudokuBoard("boards/grid-violation.sdk");
      assert !board8.isValid() : "isValid: should be false";
      assert !board8.isSolved() : "isSolved: should be false";
      if(!board8.isValid() && !board8.isSolved()) 
         System.out.println("passed.");
      else {
         System.out.println("failed.");
         allTests = false;
      }       
      
      if(allTests)
         System.out.println("**** HORRAY: ALL TESTS PASSED ****");
   }
}

   /*
  ----jGRASP exec: java -ea SudokuCheckerEngineV2
 Checking empty board...passed.
 Checking incomplete, valid board...passed.
 Checking complete, valid board...passed.
 Checking dirty data board...passed.
 Checking row violating board...passed.
 Checking col violating board...passed.
 Checking row&col violating board...passed.
 Checking mini-square violating board...passed.
 **** HORRAY: ALL TESTS PASSED ****
 
  ----jGRASP: Operation complete.
*/
  