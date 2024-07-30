package org.example.DynamicProgramming;

public class CoinChange {

    public static int findTotalWaysOfCoinChange(int coins[], int sum){
        int dp[][] = new int[coins.length+1][sum+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = 0;
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
