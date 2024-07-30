package org.example.DynamicProgramming;

public class LongestCommonSubsequence {
    //recursion - O(2^m+n)
    public static int longestsubsequestCount(String str1, String str2, int n, int m){

        if(n == 0 || m == 0)
            return 0;

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return longestsubsequestCount(str1,str2,n-1,m-1)+1;
        }

        return Math.max(longestsubsequestCount(str1,str2,n-1,m),longestsubsequestCount(str1,str2,n,m-1));

    }

    //time complexity O(n*m)
    public static int lcs_memoization(String str1, String str2, int n, int m,int dp[][]){
        if(n == 0 || m == 0)
            return 0;

        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcs_memoization(str1,str2,n-1,m-1,dp)+1;

        }

        return dp[n][m] = Math.max(lcs_memoization(str1,str2,n-1,m,dp),lcs_memoization(str1,str2,n,m-1,dp));
    }

    public static int lcs_tabulation(String str1,String str2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("longest subsequence count is "+longestsubsequestCount(str1,str2,str1.length(),str2.length()));
        System.out.println("longest subsequence count using memoization is "+lcs_memoization(str1,str2,str1.length(),str2.length(),dp));
        for(int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("longest subsequence count using tabulation is "+lcs_tabulation(str1,str2,str1.length(),str2.length()));
    }
}
