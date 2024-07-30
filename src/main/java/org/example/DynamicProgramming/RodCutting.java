package org.example.DynamicProgramming;

public class RodCutting {
    //here size of the prices is also the length of that index
    //similar to knapsack problem here, weight -> length; value -> prices; w->rodLength
    public static int rod_cutting_tabulation(int prices[],int rodLength){
        int dp[][] = new int[prices.length+1][rodLength+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i<=j){
                    dp[i][j] = Math.max(prices[i-1]+dp[i][j-i],dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[prices.length][rodLength];
    }

    public static void main(String[] args) {

        int price[]={1,5,8,9,10,17,17,20};
        int rodLength = 8;
        System.out.println("maximum profit after cutting rod in pieces is "+rod_cutting_tabulation(price,rodLength));
    }
}
