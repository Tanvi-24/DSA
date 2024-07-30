package org.example.DynamicProgramming;

public class StringConversion {

    //convert string 1 to string 2 using only deletion and insertion
    //to do that we need to find first the lcs of str1 and then add the remaining chars from str2 to string 1
    //this will give the total deletion and insertion count
    public static void printMinimumDelInsertion(String str1, String str2){
        int lcs_count = lcs(str1,str2);
        System.out.println(lcs_count);
        int deletion_count = str1.length()-lcs_count;
        System.out.println("count of deleted chars is "+ deletion_count);
        int insertion_count = str2.length()-deletion_count;
        System.out.println("count of inserted chars is "+insertion_count);

    }

    public static int lcs(String str1,String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
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
        String str1 = "abcdef";
        String str2 = "aceg";
        printMinimumDelInsertion(str1,str2);
    }
}
