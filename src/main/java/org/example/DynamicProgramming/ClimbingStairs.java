package org.example.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
    find number of ways to climb nth stair , if you can climb 1 or 2 stairs

    Tumhala n number of stairs dile aahet. Tumhi 1, 2 (or 1,2,3) steps ekach vela chadhu shakta.
    Find kara ki kitya different ways ahet nth stair var पोहोचण्यासाठी.

    Recursion (Brute Force):
    Tumhi 1 step or 2 step gheta, tar total ways:
    ways(n) = ways(n-1) + ways(n-2)
    Base cases:
    n == 0 → 1 way (reached top)
    n < 0 → 0 ways
    Time Complexity: O(2^n) (slow)

    Memoization (Top-Down DP):
    Recursive logic + dp[] array use karun results cache kele aahet.
    ways[n] madhe store kela jato jar already calculate jhala asel tar.
    Time Complexity: O(n)
    Allowing 1, 2, 3 Steps (Extended Case):
    Formula:
    ways(n) = ways(n-1) + ways(n-2) + ways(n-3)
    Memoization logic same aahe, but 3-step allowance add kela

    Tabulation (Bottom-Up DP):
    DP array fill kela bottom-up style ne.
    Start from 0 → n
    Use: dp[i] = dp[i-1] + dp[i-2]
    Time Complexity: O(n)
    Space: O(n)
 */

public class ClimbingStairs {

    //recursion
    //O(2^n)
    public static int countWays(int n){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        return countWays(n-1)+countWays(n-2);
    }

    //O(n)
    public static int memoizationCountWays(int n, int []ways){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }
        if(ways[n] != -1){ //already calculated
            return ways[n];
        }

        ways[n] = memoizationCountWays(n-1,ways)+memoizationCountWays(n-2,ways);
        return ways[n];
    }


    //using 1 2 and 3 stairs
    public static int findWays(int n, int[] ways){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }
        if(ways[n] != -1){ //already calculated
            return ways[n];
        }

        ways[n] = findWays(n-1,ways)+findWays(n-2,ways)+findWays(n-3,ways);
        return ways[n];
    }

    //O(n)
    public static int countWaysUsingTabulation(int n){
        int dp[] = new int[n+1];

        dp[0] = 1; //ways to reach 0th stair is one

        for(int i=1;i<n+1;i++){
            if(i==1){
                dp[i] = dp[i-1]+0;
            }
            else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Enter number of stairs ");
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int ways[] = new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println("count for ways to climb "+n+"th stair is "+countWays(n));
        System.out.println("count for ways to climb "+n+"th stair using memoization is "+memoizationCountWays(n,ways));
        Arrays.fill(ways,-1);
        System.out.println("count for ways to climb "+n+"th stair using memoization if allowed 1,2,3 stairs is "+findWays(n,ways));
        System.out.println("count for ways to climb "+n+"th stair using tabulation is "+countWaysUsingTabulation(n));

    }

}
