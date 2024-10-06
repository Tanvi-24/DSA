package org.example.DynamicProgramming;

/*You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.*/
public class MinimumCostToClimbStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int i=2;
        for(;i<cost.length;i++){
            dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        dp[i] = Math.min(dp[i-1],dp[i-2]);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
}
