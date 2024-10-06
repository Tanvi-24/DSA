package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSubarraySum {

    public int maxSubArray(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int j;
        int prefixPositiveSum[] = new int[nums.length];
        int prefixAllSum[] = new int[nums.length];
        prefixAllSum[0] = nums[0];
        prefixPositiveSum[0] = nums[0] > 0?nums[0]:0;
        for(int i=1;i<nums.length;i++){
            prefixPositiveSum[i] = prefixPositiveSum[i-1]+nums[i]>0?prefixPositiveSum[i-1]+nums[i]:0;
            prefixAllSum[i] = prefixAllSum[i-1]+nums[i];
        }

        for(int n:prefixPositiveSum){
            if(n>max){
                max = n;
            }
        }
        boolean isZero = Arrays.stream(nums).anyMatch(num -> num == 0);
        if(max == 0 && isZero){
            max = Integer.MIN_VALUE;
            for(int n:nums){
                if(n>max && n!=0){
                    max = n;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        maximumSubarraySum.maxSubArray(new int[]{-2, -1});
    }
}