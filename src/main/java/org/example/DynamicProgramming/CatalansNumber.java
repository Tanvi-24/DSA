package org.example.DynamicProgramming;

import java.util.Arrays;
/*
    Find the nth Catalan Number, je combinatorics problems (like unique BSTs,
    valid parentheses, triangulations etc.) solve karayla use hota.
    C(n) = Σ (C(i) * C(n-i-1)) for i = 0 to n-1

    Pure recursion.
    Time: O(2^n)
    Slow for large n due to overlapping subproblems.
    memoization
    Cache (dp[]) use karto to avoid duplicate recursive calls.
    Time: O(n²), Space: O(n)
    Tabulation
    Iteratively compute each value from 0 to n.
    Best for performance.
    Time: O(n²), Space: O(n)
 */
public class CatalansNumber {

    //time complexity O(2^n)
    public static int cataloanRec(int n){
        if(n==0||n==1){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=cataloanRec(i)*cataloanRec(n-i-1);
        }
        return ans;
    }

    public static int catalan_memoization(int n,int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalan_memoization(i, dp) * catalan_memoization(n - i - 1, dp);
        }
        return dp[n]=ans;

    }

    //O(n^2)
    public static int catalan_tabulation(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4; //won't work with recursion need to use dp for large n values
        int dp[] = new int [n+1];

        Arrays.fill(dp,-1);

//        System.out.println(cataloanRec(n));
        System.out.println(catalan_memoization(n,dp));
        System.out.println(catalan_tabulation(n));

        for(int i=1;i<=5;i++){
            System.out.println(catalan_tabulation(i));
        }
    }
}

