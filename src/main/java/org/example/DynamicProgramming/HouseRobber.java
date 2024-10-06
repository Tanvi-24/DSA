package org.example.DynamicProgramming;

/*You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.*/
public class HouseRobber {
    public static int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            Math.max(nums[0],nums[1]);
        }

        int n = nums.length;
        int dp[] = new int[n+1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int i=2;
        for(;i<nums.length;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        dp[i] = Math.max(dp[i-2],dp[i-1]);
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }
}
