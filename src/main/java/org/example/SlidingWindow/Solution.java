package org.example.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int maximumUniqueSubarray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        int i=0,j=0;
        List<Integer> list = new ArrayList<>();
        while(j < nums.length && i < nums.length){
            if(!list.contains(nums[j])){
                list.add(nums[j]);
                System.out.println(list);
                for(int k = i; k <= j; k++){
                    sum+=nums[k];
                }
                max = Math.max(max,sum);
                sum = 0;
            }
            else{
                    i++;
            }


            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));

    }
}