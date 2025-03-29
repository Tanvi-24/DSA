package org.example.DynamicProgramming;

import java.util.Scanner;
/*
    Find the nth Fibonacci number using Dynamic Programming.
    Fibonacci series:
    0, 1, 1, 2, 3, 5, 8, 13, ...
    Formula: fib(n) = fib(n-1) + fib(n-2)

    He code efficiently compute karto Fibonacci using bottom-up DP,
    without recursion or stack overflow issues. Very commonly asked in interviews
    to test basic DP skills.
 */
public class Fibonacci {

    public static int fib(int num){
        int dp[] = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<num+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[num];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number ");
        int n  = sc.nextInt();

        System.out.println(n+"th fibonacci number is "+fib(n));
    }
}
