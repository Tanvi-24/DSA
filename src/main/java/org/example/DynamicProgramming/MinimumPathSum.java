package org.example.DynamicProgramming;

public class MinimumPathSum {

    //moves right and bottom
    public static int minPathSum(int[][] grid) {
            int dp[][]= new int[grid.length][grid[0].length];
            int m=grid.length;
            int n=grid[0].length;
            return f(m-1,n-1,grid,dp);

    }
    public static int f(int i,int j,int mat[][],int dp[][]){
        if((i==-1)||(j==-1))
            return Integer.MAX_VALUE;
        else if((i==0)&&(j==0))
            return mat[0][0];
        else{
            if(dp[i][j]!=0){
                return dp[i][j];
            }
            int t1=f(i-1,j,mat,dp);//move up
            int t2=f(i,j-1,mat,dp); //move left
            dp[i][j] = Math.min(t1,t2)+mat[i][j]; //find minimum move
            return dp[i][j];
        }
    }

    //moves right and up
    public static int minimumPathSum(int [][]grid){
        int dp[][]= new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return findSum(grid.length-1,0,grid,dp);
    }

    public static int findSum(int r, int c, int grid[][], int dp[][]){
        if((r==-1)||(c==-1) || r==grid.length || c==grid[0].length)
            return Integer.MIN_VALUE;

        if(r==0 && c == grid[0].length-1){
            return grid[0][grid[0].length-1];
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int p1 = findSum(r-1,c,grid,dp);
        int p2 = findSum(r,c+1,grid,dp);
        dp[r][c] = Math.max(p1,p2)+grid[r][c];
        return dp[r][c];
    }
    public static void main(String[] args) {
        int [][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        int [][]grid2 = {{0, 0, 0, 0, 5},{0, 1, 1, 1, 0},{2, 0, 0, 0, 0}};
        System.out.println("minimum path sum from top to bottom when you can move only right and down "+minPathSum(grid));
        System.out.println("minimum path sum from bottom to up when you can move only right and up "+minimumPathSum(grid2));
    }
}
