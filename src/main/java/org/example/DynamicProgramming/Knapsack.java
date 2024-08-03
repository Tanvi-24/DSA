package org.example.DynamicProgramming;

import java.util.Arrays;

public class Knapsack {

    //normal recursion
    public static int knapsack(int val[],int wt[],int w, int n){
        if(w==0 || n==0){
            return 0;
        }

        if(wt[n-1]<=w){//valid
            //include
            int ans1 = val[n-1]+knapsack(val,wt,w-wt[n-1],n-1);
            //exclude
            int ans2 = knapsack(val,wt,w,n-1);
            return Math.max(ans2,ans1);
        }
        else { //not valid
            return knapsack(val,wt,w,n-1);
        }
    }

    //memoization
    public static int memoization_knapsack(int val[],int wt[],int w, int n,int dp[][]){
        //O(n*w)
        if(w==0 || n==0){
            return 0;
        }

        if(dp[n][w]!=-1){
            return dp[n][w];
        }

        if(wt[n-1]<=w){//valid
            //include
            int ans1 = val[n-1]+memoization_knapsack(val,wt,w-wt[n-1],n-1,dp);
            //exclude
            int ans2 = memoization_knapsack(val,wt,w,n-1,dp);
            dp[n][w] = Math.max(ans1,ans2);
            return dp[n][w];
        }
        else { //not valid
            dp[n][w] = memoization_knapsack(val,wt,w,n-1,dp);
            return dp[n][w];
        }
    }

    //tabulation
    public static int tabulation_knapsack(int val[], int wt[], int w, int n){
        int dp[][] = new int[n+1][w+1];

        for(int i=0;i<n+1;i++){
         dp[i][0] = 0;
        }
        for(int j=0;j<w+1;j++){
         dp[0][j] = 0;
        }

        for (int i=1;i<n+1;i++){
            for (int j=1;j<w+1;j++){
                int v = val[i-1];
                int weight = wt[i-1];
                if(weight<=j){
                    int include = v+dp[i-1][j-weight];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }
                else {
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;
                }
            }
        }

        for(int i=0;i<val.length+1;i++){
            System.out.println();
            for (int j=0;j<w+1;j++){
                System.out.print(dp[i][j]+ " ");
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;

        //no of rows is n+1
        //no of columns is w+1
        int dp[][]= new int[val.length+1][w+1];
        for(int i=0;i<val.length+1;i++){
            for (int j=0;j<w+1;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(val,wt,w,val.length));
        System.out.println(memoization_knapsack(val,wt,w,val.length,dp));
        for(int i=0;i<val.length+1;i++){
            System.out.println();
            for (int j=0;j<w+1;j++){
                System.out.print(dp[i][j]+ " ");
            }
        }
        System.out.println("\n\n"+tabulation_knapsack(val,wt,w,val.length));
    }
}