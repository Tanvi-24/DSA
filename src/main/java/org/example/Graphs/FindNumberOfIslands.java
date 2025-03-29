package org.example.Graphs;

/*
    Aplyala ek 2D grid dila ahe char[][] format madhe jithe:
    '1' represents land
    '0' represents water
    Tumhala kitne "islands" ahet te count karayche ahe.
    Island mhnje adjacent land blocks ('1') connected horizontally or vertically.

    Traverse each cell of the grid.
    Jithe '1' milta, mhnje navi island start zali.
    totalIslands++ kara ani tyachya saglya connected '1' cells la visit kara using DFS.
    Visit zalele '1' grid la '0' madhe convert kara (mhnje visited).

    O(m * n) where m = rows and n = columns
    DFS call for each unvisited '1'

 */
public class FindNumberOfIslands {
    public static int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0){
            return 0;
        }
        int totalIslands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    totalIslands++;
                    dfs(grid,i,j);
                }
            }
        }

        return totalIslands;
    }

    public static void dfs(char [][]grid, int i, int j){
        if(i<0||j>=grid[0].length||i>=grid.length||j<0||grid[i][j] != '1'){
            return;
        }

        grid[i][j] = '0';//mark visited
        //check for all four directions
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        char grid[][]={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
