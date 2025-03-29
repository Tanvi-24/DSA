package org.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
    Aplyala ek 2D char matrix (maze) dila ahe jithe '+' = wall and '.' = open path.
    Tumhala entrance position dila ahe, and you have to find the minimum steps to reach
    the nearest exit (edge of the maze) using BFS traversal.

    Initialization:
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    Queue<Pair> queue = new LinkedList<>();
    directions define karto 4 possible directions (right, down, left, up).
    BFS sathi queue use kartoy.
    Entrance point queue madhe add kelay.

     BFS Traversal:
    while(!queue.isEmpty()){
       // level wise traverse (min steps track karayla)
    }
    BFS traversal karto, step-by-step.
    Jithe '.' asel, tithun pudhe move karto.
    Maze madhe visited mark kartoy by replacing . with '+'.

     Exit Condition:
    if((row != entrance[0] || col != entrance[1]) && (row==0 || row==n-1 || col==0 || col==m-1)){
       return min;
    }
    Jara apan entrance la sodun kahi dusra edge reach kelay tar that’s an exit → return the step count.

    O(N * M), where N = rows, M = columns (BFS visit every cell once)
 */
public class SolveMaze {
    public class Pair{
        int a;
        int b;

         public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int min = 0;
        int [][]directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(entrance[0],entrance[1]));
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                Pair pair = queue.remove();
                int row = pair.a;
                int col = pair.b;

                if((row!=entrance[0]||col!=entrance[1])&&(row == 0 || row == n-1 || col == 0 || col == m-1)){
                    return min;
                }

                for(int [] dir:directions){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];

                    if(newRow >=0 && newRow <n && newCol>=0 &&newCol<m && maze[newRow][newCol] == '.'){
                        maze[newRow][newCol] = '+';
                        queue.add(new Pair(newRow,newCol));
                    }
                }
            }
            min++;
        }

        return -1;
    }

    public static void main(String[] args) {
        char [][]maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int entrance[] = {1,2};
        SolveMaze solveMaze = new SolveMaze();
        System.out.println(solveMaze.nearestExit(maze,entrance));
    }
}
