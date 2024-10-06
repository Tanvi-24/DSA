package org.example.array;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int currSum=0;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>(); //key-currentSum, value-count

        for(int n:nums){
            currSum+=n;
            if(currSum == k){
                count++;
            }
            if(!map.containsKey(currSum)){
                map.put(currSum,1);
            }
            else{
                map.put(currSum,map.get(currSum)+1);
            }
            if(map.containsKey(currSum-k)){
                count+=map.get(currSum-k);
                map.put(currSum-k,map.get(currSum-k)+1);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.subarraySum(new int[]{1}, 0);
    }
}