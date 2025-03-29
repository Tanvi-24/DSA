package org.example.DynamicProgramming;
/*
    You have to find the n-th Tribonacci number.
    Like Fibonacci, but instead of summing last 2, it sums last 3:
    T(0) = 0, T(1) = 1, T(2) = 1
    T(n) = T(n-1) + T(n-2) + T(n-3)

    Use Bottom-Up Dynamic Programming (Tabulation).
    Create a dp[] array where:
    dp[0] = 0, dp[1] = 1, dp[2] = 1

 */
public class NthTribonnaciNumber {
    public static int tribonacci(int n) {
        if(n== 0 || n==1){
            return n;
        }

        if(n==2){
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
}
