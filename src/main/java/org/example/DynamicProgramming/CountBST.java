package org.example.DynamicProgramming;

public class CountBST {
    //find number of all possible BST's with given n nodes

    public static int findNoOfBST(int n){
        if(n==0||n==1){
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+= dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n=4; //n can be no. of nodes of a tree or for confusing you will be given an array, here n will be size of array
        System.out.println(findNoOfBST(n));

    }
}
