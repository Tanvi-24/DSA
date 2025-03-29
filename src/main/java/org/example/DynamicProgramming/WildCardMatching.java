package org.example.DynamicProgramming;
/*
    Given a string str and a wildcard pattern, check whether the string matches the pattern.
    ? matches exactly one character
    * matches any number (including 0) of characters
    Check if pattern and str completely match considering the wildcards.
    Use Dynamic Programming (Tabulation) to fill a 2D DP table where:
    dp[i][j] = true if first i characters of str match first j characters of pattern.
    Initialization
    dp[0][0] = true → empty string and empty pattern match.
    dp[i][0] = false → non-empty string can't match empty pattern.
    dp[0][j] = true only if all previous pattern characters are * (they can represent empty string).
    For i in string and j in pattern:
    If pattern[j-1] == '*' →
    Two choices: * can match 0 or more chars:
    dp[i][j] = dp[i][j-1] || dp[i-1][j]
    If characters match directly or pattern[j-1] == '?' →
    dp[i][j] = dp[i-1][j-1]

    Example
    str = "baaabab"
    pattern = "*****ba*****b"
    This pattern matches the string completely → Output: true

 */
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