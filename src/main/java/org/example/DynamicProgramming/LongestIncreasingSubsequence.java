package org.example.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
/*
    Tumhala dilelya array madhe Longest Increasing Subsequence (LIS) chi length find karaychi aahe.
    Increasing subsequence = elements cha order maintain karto (not necessarily contiguous).
    Example: {50, 3, 10, 7, 40, 80} → LIS is {3, 7, 40, 80} → length 4.

    HashSet vaprun duplicates remove kele.
    Unique elements sort kele → get strictly increasing sequence (arr2).
    arr1 (original array) ani arr2 (sorted unique array) var Longest Common Subsequence (LCS) apply kelay.
    LIS = LCS(original, sorted unique array)

    LCS Function:
    dp[i][j] = LCS length for arr1[0..i-1] and arr2[0..j-1].
    If elements match: dp[i][j] = dp[i-1][j-1] + 1.
    Else: take max from top or left cell.
    O(n^2) due to LCS with DP.

 */
public class LongestIncreasingSubsequence {
    public static int lis(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        int i=0;
        for(int n:set) {
            arr2[i] = n;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr,arr2);
    }

    public static int lcs(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int i=0;i<m+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] =  dp[i-1][j-1]+1;
                }
                else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int arr[] = {50,3,10,7,40,80};
        System.out.println("length of longest unique increasing subequence is "+lis(arr));
    }
}
