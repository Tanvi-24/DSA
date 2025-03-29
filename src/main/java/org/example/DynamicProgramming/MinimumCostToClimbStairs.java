package org.example.DynamicProgramming;

/*You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.*/

/*
    Problem Summary:
    Tumhala ek cost[] array dila ahe, jithe cost[i] means the cost to stand on i-th step.
    Tumhi step 0 kiva step 1 varun start karu shakta.
    Ekda tumhi cost bharla ki tumhi 1 step kiva 2 steps pudhe jau shakta.
    Goal: Find the minimum cost to reach the top (after the last index).

    DP array dp[i] store karto minimum cost to reach step i.
    Initialization:
    dp[0] = cost[0]
    dp[1] = cost[1]
    For loop through step 2 to n-1:
    dp[i] = cost[i] + min(dp[i-1], dp[i-2])
    i.e., current step paryant yeayla tumhi eka step backun yenar ka don steps backun yenar — je minimum cost asel.
    Last step reach karun nantar top la yeaycha cost:
    dp[n] = min(dp[n-1], dp[n-2]) — karan top la last kiva second last step varun yeu shakto.

    For cost = [10,15,20]:
    dp[0] = 10
    dp[1] = 15
    dp[2] = 20 + min(15,10) = 30
    dp[3] = min(30,15) = 15
    ✅ Answer: 15 is the minimum cost to reach top.
 */
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
