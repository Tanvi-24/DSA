package org.example.array;

import java.util.Arrays;
/*
    maxSubArrayEfficient method (Kadane’s Algorithm simplified):
    Code ek single loop use karun maximum subarray sum efficiently shodhato.
    currentSum ani maxSum track karto; jar currentSum negative zala tar to discard karun
    next number pasun suruvat karto ani final madhe maximum sum return karto.
    maxSubArray method (Prefix Sum approach with extra checks):
    Code madhe prefixPositiveSum array create karun sum store karto, ani tyatun maximum sum kadhto.
    Jar sagle numbers negative or zero asle tar special condition check karun largest negative
    number return karto.
    Overall:
    Donhi method madhun array madhla maximum subarray sum shodhnyacha prayatna aahe,
    pan pahili method (efficient) simple ani fast aahe (Kadane’s algorithm).
 */
public class MaximumSubarraySum {

    public int maxSubArrayEfficient(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        if(nums.length == 0 ){
            return 0;
        }
        for(int n:nums){
            currentSum = Math.max(currentSum+n,n);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int j;
        int prefixPositiveSum[] = new int[nums.length];
        //find max sum using kadane's algorithm
        prefixPositiveSum[0] = nums[0] > 0?nums[0]:0;
        for(int i=1;i<nums.length;i++){
            prefixPositiveSum[i] = prefixPositiveSum[i-1]+nums[i]>0?prefixPositiveSum[i-1]+nums[i]:0;
        }

        for(int n:prefixPositiveSum){
            if(n>max){
                max = n;
            }
        }
        //if max is zero i.e if all the numbers in the array are either zero or negative
        //for non-positive values we will find the largest negative value in the array which
        // does not have a zero in the array
        boolean isZero = Arrays.stream(nums).anyMatch(num -> num == 0);
        if(max == 0 && !isZero){
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
        System.out.println(maximumSubarraySum.maxSubArray(new int[]{-2, -1}));
        System.out.println(maximumSubarraySum.maxSubArrayEfficient(new int[]{-2, -1}));
    }
}