package org.example.DynamicProgramming;

import java.util.Arrays;

/*
    matrix chain multiplication
    umhala n matrices dile aahet jyanche dimensions arr[] madhe aahet.
    Tumhala minimum cost (number of scalar multiplications) find karaychi aahe
    parenthesis changin karun.
    Example: 4 matrices of dimensions 1x2, 2x3, 3x4, 4x3 → arr = {1, 2, 3, 4, 3}

    Recursion Approach:
    i to j matrices multiply karayche aahet.
    k ha split point use kela, jithe i to k and k+1 to j multiply kele.
    cost1 = cost to multiply i to k
    cost2 = cost to multiply k+1 to j
    cost3 = actual multiplication of resulting matrices → arr[i-1]*arr[k]*arr[j]

    Time Complexity:
    Recursion: Exponential, due to overlapping subproblems.
    You can improve with Memoization (dp[i][j]) or Tabulation (Dynamic Programming).
    O(n³) due to 3 nested loops in recursion + memoization
    Space: O(n²) for DP table

 */
public class MCM {

    public static int mcm_memoization(int arr[], int i, int j, int[][] dp) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm_memoization(arr, i, k, dp);
            int cost2 = mcm_memoization(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }

    public static int mcm_recursion(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans  = Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int cost1 = mcm_recursion(arr,i,k);
            int cost2 = mcm_recursion(arr,k+1,j);
            int cost3 = arr[i-1]* arr[k] * arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans,finalCost);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        int[][] dp = new int[arr.length][arr.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int n = arr.length;
        System.out.println(mcm_recursion(arr,1,n-1));
        System.out.println("Minimum number of scalar multiplications: " + mcm_memoization(arr, 1, n - 1, dp));

    }
}
