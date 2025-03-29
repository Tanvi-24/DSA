package org.example.DynamicProgramming;
/*
    Given:
    val[] → values of items
    wt[] → weights of items
    w → total capacity of the bag
    You can pick the same item multiple times (unbounded),
    and the goal is to maximize the total profit without exceeding the weight limit.

    Use Dynamic Programming (Tabulation) where:
    dp[i][j] = maximum profit using first i items and bag capacity j.
     Initialization:
    First row dp[0][j] = 0 → no items, no profit.
    First column dp[i][0] = 0 → 0 capacity, no profit.

    Transition:
    For every item i and weight j:
    If item weight ≤ current capacity (j):
    include =  Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]); (pick same item again)
    exclude = dp[i-1][j] (skip item)
    dp[i][j] = max(include, exclude)
    Else, skip the item → dp[i][j] = dp[i-1][j]

     Example:
    val[] = {15,14,10,45,30}
    wt[] = {2, 5, 1, 3, 4}
    w = 7
    → Maximum profit is calculated and stored in dp[val.length][w].
    ✅ Output:

    You get the maximum profit that can be obtained by picking items multiple times
    without crossing the weight limit.
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7;
        int dp[][] = new int[val.length+1][w+1];

        for(int i=0;i<val.length+1;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<w+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("max profit for unbounded knapsack is "+ dp[val.length][w]);
        for(int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
