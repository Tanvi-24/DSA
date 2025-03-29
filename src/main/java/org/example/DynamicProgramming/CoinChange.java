package org.example.DynamicProgramming;
/*
    This is a classic unbounded knapsack type DP problem.
    Tumhala coins cha array dila aahe (e.g., {2,5,3,6}) aani ek target sum (e.g., 10) dila aahe.
    Tumhala sangaycha aahe ki kitkya different ways aahet to form that sum using unlimited supply
    of those coins.

    Approach: Dynamic Programming (Tabulation - Bottom-Up)
    int dp[coins.length + 1][sum + 1];
    dp[i][j] = Number of ways to make sum j using first i coins.
    For every coin:
    Include it → dp[i][j - coin]
    Exclude it → dp[i-1][j]
    Total = sum of both
    dp[i][j - coin] = include current coin
    dp[i-1][j] = skip current coin
    Addition because both ways are valid
 */
public class CoinChange {

    public static int findTotalWaysOfCoinChange(int coins[], int sum){
        int dp[][] = new int[coins.length+1][sum+1];
        //initialization
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1; // 1 way to make sum 0 (take no coins)
        }
        //initialization
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = 0; // 0 ways to make any positive sum using 0 coins
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
               int coin = coins[i-1];
               if(coin<=j){
                   dp[i][j] = dp[i][j-coin]+dp[i-1][j];
               }
               else {
                   dp[i][j] = dp[i-1][j];
               }
            }
        }
        for(int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[coins.length][sum];
    }

    public static void main(String[] args) {
        int coins[] = {2,5,3,6};
        int sum = 10;
        System.out.println("number of ways to get total sum as "+ sum + " is " +findTotalWaysOfCoinChange(coins,sum));
    }
}
