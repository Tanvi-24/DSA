package org.example.DynamicProgramming;

public class LongestCommonSubstring {

    public static int getLongestCommonSubstring(String str1, String str2, int n, int m){
        int ans = Integer.MIN_VALUE;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for (int j=0;j<m+1;j++){
                if(n == 0|| m == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(dp[i][j],ans);
                }
                else {
                    //different character so reset value and start checking new substring
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println();
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abdcde";

        System.out.println("longest common substring  "+ getLongestCommonSubstring(str1,str2,str1.length(),str2.length()));
    }
}
