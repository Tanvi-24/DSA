package org.example.backtracking;

/*
    RatMaze problem madhe maze madhlya top-left position (0,0) pasun bottom-right position
    paryant pochaychya total paths calculate kele ahet.
    Maze madhye 1 mhanje open cell (jate yeil) ani 0 mhanje blocked cell (jate yenar nahi).
    Recursion (mazeSolver) vaprun don directions la (right ani down) move karun sagle possible
     rastyanche combinations check kele; jar destination cell paryant pohochla tar count 1 return karto,
      nahi tar backtrack karto.
    Ha simple recursive approach aahe, hyachi complexity high (O(2^(m+n))) aste,
    pan recursion ani backtracking cha use karun sagle possible paths generate kartoy.
*/
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
