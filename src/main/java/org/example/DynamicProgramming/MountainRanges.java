package org.example.DynamicProgramming;
/*
    You’re given n pairs of upstroke / and downstroke \.
    You need to find the number of valid mountain structures that can be formed using these.
    Every / must be matched with a \.
    At no point should the number of \ exceed / while building the structure
    (like balanced parentheses).
    For example, "/\\" is valid, but "\\/" is not.

    This is a Catalan Number problem.
    Let dp[i] = number of valid mountains using i pairs.
    Use bottom-up DP:
    dp[i] += dp[j] * dp[i - j - 1] for j = 0 to i-1;
    Here, dp[j] → number of mountains inside one pair,
    and dp[i-j-1] → number of mountains outside that.

    For n = 3, output is 5,
    which means 5 different valid mountain structures can be formed using 3 /\ pairs.
 */
//find all possible mountains/valleys that can be created using pair of upstroke and downstrok / \
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