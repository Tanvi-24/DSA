package org.example.backtracking;

public class GridWays {
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
    int m=3,n=3;
        System.out.println("total ways to reach grid "+gridWaysSolution(0,0,n,m));
    }
}
