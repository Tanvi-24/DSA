package org.example;

import java.util.Arrays;

public class MissingNumbers {
    public static int missingNumber(int[] nums) {

        int size = nums.length;
        int dp[] = new int[size+1];
        Arrays.fill(dp,-1);

        for(int i=0;i<size;i++){
            dp[nums[i]] = nums[i];
        }

        for(int i=0;i<dp.length+1;i++){
            if(dp[i] == -1){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {0,2,3};
        System.out.println(missingNumber(arr));
    }
}
