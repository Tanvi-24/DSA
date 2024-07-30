package org.example.DynamicProgramming;

import java.util.Scanner;

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
