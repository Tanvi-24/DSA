package org.example.backtracking;
/*
    Sudoku problem madhe, 9x9 Sudoku puzzle cha valid solution recursive backtracking method (sudokuSolver)
     ni shodhlela ahe.
    Method madhye pratyek empty cell (0) madhe digits 1 to 9 try kele, ani isSafe() function vaprun
    check kele ki digit row, column, ani 3x3 grid madhe safe aahe ka nahi.
    Digit safe asal tar recursion pudhlya cell sathi continue karto;
    jar pudhlya level la solution nahi milala tar backtrack karto ani dusra digit try karto.
    Base case (row == 9) paryanta successfully pochlyavar solution exist karto ani puzzle print karun dakhavto.
    Recursive backtracking mule effectively Sudoku puzzle solve karte,
     jar possible nasel tar "Solution does not exist" dakhavto.
 */
public class Sudoku {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        //column
        for(int i=0;i<=8;i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //row
        for (int j=0;j<=8;j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        //grid
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow;i<startRow+3;i++){
            for(int j= startCol;j<startCol+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
     //base case
        if(row == 9){
            return true;
        }

      // recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku,nextRow,nextCol);
        }
        for(int digit =1; digit<=9; digit++){
          if(isSafe(sudoku,row,col,digit)){
              sudoku[row][col] = digit;
              if(sudokuSolver(sudoku,nextRow, nextCol)){
                  return true;
              }
              sudoku[row][col] = 0;
          }
        }
        return false;
    }

    public static void main(String... args){
        int sudoku[][] ={{0,0,8,0,0,0,0,0,0},
                {4,9,0,1,5,7,0,0,2},{0,0,3,0,0,4,1,9,0},
                {1,8,5,0,6,0,0,2,0},
                {0,0,0,0,2,0,0,6,0},
                {9,6,0,4,0,5,3,0,0},
                {0,3,0,0,7,2,0,0,4},
                {0,4,9,0,3,0,0,5,7},
                {8,2,7,0,0,9,0,1,3}
        };

        if(sudokuSolver(sudoku,0,0)){
            System.out.println("Sudoku solution exist");
            printSudoku(sudoku);
        }else{
            System.out.println("Sudoku Solution does not exist");
        }
    }

    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[0].length;j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
