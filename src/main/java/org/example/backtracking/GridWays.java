package org.example.backtracking;

public class GridWays {
    /*
    GridWaysSolution (Backtracking/Recursion) in Brief:
    Ha code top-left cell (0,0) pasun bottom-right cell (n-1,m-1) paryanta pochayche
    total possible ways count karto.


    Recursion use karun, ekda right (j+1) ani ekda down (i+1) move karto,
    boundary cross zalya (i==n or j==m) ki return 0 karto, ani goal (n-1,m-1) paryant pochala tar return 1.

    Overall:
    Code recursive backtracking cha concept use karun possible paths cha count karto,
     pan hyachi complexity high aste (O(2^(m+n))),
     ji combination (permutation) formula ne optimize karta yete.(m-1+n-1)!/((n-1)! * (m-1)!)
     */
    //time complexity = O(2^(m+n))
    //we can reduce the time complexity by using permutation formula
    // (m-1+n-1)!/((n-1)! * (m-1)!)
    public static int gridWaysSolution(int i, int j, int n, int m){
        //base case
        if(i==n-1 && j == m-1){
            return 1;
        }
        //boundary cross solution
        else if(i == n || j == m)
        {
            return 0;
        }

        //goes to down direction
        int w1 = gridWaysSolution(i+1,j,n,m);
        //goes to right direction
        int w2 = gridWaysSolution(i,j+1,n,m);
        return w1+w2;
    }
    public static void main(String[] args) {
    int m=3,n=7;
        System.out.println("total ways to reach grid "+gridWaysSolution(0,0,n,m));
        /*
        call grid ways solution call(grid,0,0,m-1,n-1,Integer.MIN_VALUE)
        int sum = 0;
        int call(grid,int sr,int sc,int er, int ec, int sum){
        if(sc>ec || sr>er){
        return 0;
        }

        call(sr+1,sc,m-1,n-1,sum),min(


        sum = sum+grid[startr][startc]

        call(
        */
    }
}
