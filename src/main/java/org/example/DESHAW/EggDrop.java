package org.example.DESHAW;
/*
    Tumchya kade k eggs aahet ani n floors aahet.
    Tumhala find karaycha aahe minimum number of attempts to determine highest floor jya varun egg break hotay.
    ✅ Logic Used (Optimized DP):
    dp[j][i] = Maximum number of floors you can check using j eggs in i moves (attempts).
    Formula:
    dp[j][i] = dp[j-1][i-1] + dp[j][i-1] + 1
    dp[j-1][i-1]: case where egg breaks
    dp[j][i-1]: case where egg does not break
    +1: current floor attempt
    Iterate until dp[k][i] >= n, mhanje enough attempts to cover all floors.
    ✅ Code Flow Summary:
    Loop through increasing number of attempts (i from 1 to n)
    For each number of eggs (j), calculate how many floors we can check using above formula.
    As soon as dp[k][i] >= n, return i (minimum required attempts)
    ✅ Complexity:
    Time: O(n*k)
    Space: O(n*k)
 */
public class EggDrop {
    public static int superEggDrop(int k, int n) {
        int[][] dp=new int[k+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[j][i]=dp[j-1][i-1]+dp[j][i-1]+1;
                if(dp[j][i]>=n) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(1,2));
    }
}
