package org.example.backtracking;

public class RatMaze {
    public static void main(String[] args) {
        int maze [][]= {{ 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 1, 0 },
                        { 1, 1, 1, 1 } };


        System.out.println(mazeSolver(maze,0,0));
    }

    public static int mazeSolver(int maze[][], int row, int col){

        //base
        if(row == maze.length-1 && col == maze[0].length-1){
            return 1;
        }

        if(row==maze.length || col == maze[0].length)
            return 0;

        //recursion
        if(maze[row][col]!=0)
        {
            int w1 = mazeSolver(maze,row+1,col);
            int w2 = mazeSolver(maze,row, col+1);
            return w1+w2;
        }

       return 0;
    }
}
