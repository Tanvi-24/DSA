package org.example.DynamicProgramming;
/*
    Find the maximum profit by cutting a rod of length n into pieces, where each piece of
    length i has a given price[i-1].
    This is similar to Unbounded Knapsack:
    weights → lengths
    values → prices
    capacity → rodLength

    Approach (Tabulation - Bottom Up):
    Create a DP table dp[i][j], where:
    i = piece size (1 to n)
    j = current rod length
    Base cases:
    dp[i][0] = 0 (zero rod length = zero profit)
    dp[0][j] = 0 (no pieces to cut = zero profit)

    Include the piece: Add its price + solve for remaining length.
    Exclude the piece: Move to smaller size

    prices = [1,5,8,9,10,17,17,20] and rodLength = 8
    Answer: 22
    One way: 2 cuts of length 2 (5+5), 2 cuts of length 2 again (5+5), etc.,
    based on max combinations.
 */
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
