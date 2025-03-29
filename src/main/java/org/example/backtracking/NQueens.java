package org.example.backtracking;

/*
    - NQueens problem madhe, ek chessboard var "N" queens aashya thevaychya
        ki konich ekmekanna attack karu naye (row, column, diagonal madhye).

    - Ha code backtracking cha use karun sagle possible combinations generate karto,
     ani check karto ki position safe aahe ka (`isSafe()`).

    - `nQueensSolution()` madhye queen safe asal tar queen (`Q`) place karto,
     recursion ne pudhlya row sathi same try karto; jar pudhe possible nahi zal tar backtrack karto ani queen remove karto (`X`).

    - Saglya rows (`n`) paryant queens successfully place zalya tar solution print karto,
     ani final madhe total solutions cha count print karto.
 */
public class NQueens {
    //time complexity = O(n!)
    static int count =0;
    public static void nQueensSolution(char board[][],int row){
        if(row == board.length){
            printBoard(board);
            count++;
            return;
        }

        //column loop
            for(int i=0;i<board.length;i++){
                if(isSafe(board,row,i)){
                    board[row][i]='Q';
                    nQueensSolution(board,row+1);
                    board[row][i]='X';
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        //vertical up
        for(int i= row-1;i>=0;i--){
            if(board[i][col] == 'Q')
                return false;
        }
        //diagonal left
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }
        //diagonal right
        for (int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }



    public static void printBoard(char [][]board){
        System.out.println("------Chess Board------");
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int n=5;
        char board[][] = new char[n][n];

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                board[i][j] = 'X';
            }
        }
        nQueensSolution(board,0);
        System.out.println("Total ways to solve N Queens is "+count + " for board of length "+n);
    }
}
