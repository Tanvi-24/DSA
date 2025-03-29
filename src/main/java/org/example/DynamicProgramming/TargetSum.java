package org.example.DynamicProgramming;
/*
    Given an array numbers[] and a target sum,
    check whether any subset of elements can add up to exactly that sum.
    This is a classic Subset Sum Problem, and it's solved using Tabulation (Bottom-Up DP).
    Logic Behind the Code:
    dp[i][j] tells whether we can achieve sum j using the first i elements of the array.
    Initialization:
    dp[i][0] = true for all i: Because you can always form sum 0 by taking nothing.
    dp[0][j] = false for all j > 0: You can't form any positive sum with 0 elements.

    Transitions:
    For each element:
    Either you include the current number val if val <= j.
    dp[i][j] = dp[i-1][j-val]
    Or you exclude the current number.
    dp[i][j] = dp[i-1][j]
    Final answer will be in dp[n][sum] (where n = numbers.length).
 */
//example of unbounded knapsack
public class TargetSum {
    //time complexity - O(n*sum)
    public static boolean tabulation_target_sum(int numbers[], int sum){
        boolean dp[][] = new boolean[numbers.length+1][sum+1];

        if(sum == 0 && numbers.length == 0){
            return true;
        }
        // here i and j meaning, where i is the subset values which could be equal till the sum i.e j
        //for every i, j pair we are defining if we are able to get the sum (j) using (0-i) items
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }


        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int val = numbers[i-1];
               //valid and include condition
                if(val <= j && dp[i-1][j-val] == true){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j] == true){ //exclude
                    dp[i][j] = true;
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[numbers.length][sum];

    }
    public static void main(String[] args) {
        int numbers[] = {4,2,7,1,3};
        int sum = 10;
        System.out.println("\ntarget sum present in the given array - "+tabulation_target_sum(numbers,sum));
    }

}
