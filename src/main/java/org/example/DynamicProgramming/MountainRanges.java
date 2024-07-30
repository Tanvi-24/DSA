package org.example.DynamicProgramming;

//find all possible montains/valleys that can be created using pair of upstroke and downstrok / \
public class MountainRanges {

    public static int findNoOfMountains(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("No. of possible mountains is "+findNoOfMountains(n));
    }
}