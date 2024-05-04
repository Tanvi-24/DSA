package org.example.DESHAW;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];
        int prefix_product=1;
        int suffix_product=1;

        for(int i=0;i<nums.length;i++){
            answer[i]=prefix_product;
            prefix_product=prefix_product*nums[i];
        }

        for(int j=(nums.length)-1;j>=0;j--){
            answer[j]*=suffix_product;
            suffix_product= suffix_product*nums[j];
        }
        return answer;
    }

    public static void main(String[] args) {
        Arrays.stream(productExceptSelf(new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }
}
