package org.example;

public class TwoDArray {

    public static void main(String args[]){
        int matrix [][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralMatrix(matrix);
        System.out.println("************");
        int digMatrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        diagonalSum(digMatrix);
        System.out.println("************");
        int sortedMatrix[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        System.out.println("search key in sorted matrix");
        boolean find = searchSortedMatrix(33,sortedMatrix);
        if(!find){
            System.out.println("key not found");
        }

    }

    public static void spiralMatrix(int matrix[][]){
        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;

        /*
        * 1  2  3  4
        * 5  6  7  8
        * 9 10 11 12
        * */
        //traverse sequentially covering row then col, then row and then again col

        System.out.println("Spiral Matrix");
        while (startRow<=endRow && startCol <= endCol){
            //top row
            for(int i = startCol; i<=endCol;i++){
                System.out.print(matrix[startRow][i]+ " ");
            }

            //right col
            for (int j = startRow+1; j<=endRow; j++){
                System.out.print(matrix[j][endCol]+ " ");
            }

            // bottom row
            for(int i= endCol-1; i>=startCol; i--){
                if(startRow == endRow)
                {
                    break;
                }
                System.out.print(matrix[endRow][i]+" ");
            }

            //left col
            for (int j = endRow-1; j>startRow; j--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[j][startCol]+ " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
            System.out.println();
        }
    }

    public static void diagonalSum(int matrix[][]){
        /*
        *  1   2   3   4
        *  5   6   7   8
        *  9  10  11  12
        * 13  14  15  16
        * */
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        int totalSumoFDiagonal = 0;

        if(matrix.length == matrix[0].length){
            int k = endCol;

            for(int i = startRow,j=startCol;i<=endRow&&j<=endCol; i++,j++){
                totalSumoFDiagonal = totalSumoFDiagonal+matrix[i][j];

                totalSumoFDiagonal = totalSumoFDiagonal+matrix[i][k];
                k--;
            }

            if(matrix.length%2!=0){
               totalSumoFDiagonal = totalSumoFDiagonal - matrix[matrix.length/2][matrix.length/2];
            }
        }
        System.out.println("Sum of diagonals is : "+totalSumoFDiagonal);

    }

    public static boolean searchSortedMatrix(int key, int matrix[][]){

        int row = 0, col= matrix[0].length-1;
        while(row < matrix.length && col>=0){
            if(matrix[row][col] == key) {
                System.out.println("key found at (" + row + "," + col + ") position");
                return true;
            }
            else if(key<matrix[row][col]){
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}
