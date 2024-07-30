package org.example.DynamicProgramming;

public class WildCardMatching {

    public static boolean stringMatchPattern(String str,String pattern){
        int n = str.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n+1][m+1];

        //since when str and pattern both are empty they match
        dp[0][0] = true;

        //when pattern is empty
        for(int i=1;i<n+1;i++){
            dp[i][0] = false;
        }

        //when string is empty
        for(int i=1;i<m+1;i++){
            if(pattern.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){

                if(pattern.charAt(j-1) == '*'){
                    // do comparative OR between when pattern is * and considered as empty or * is considered as the string
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "*****ba*****b";
        System.out.println("does string match the pattern ? "+stringMatchPattern(str,pattern));
    }
}