package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {


    public static void main(String args[]){
        Array array = new Array();
        int  numbers[] = {1,-2,6,-1,3};
        int height[] ={4,2,0,6,3,2,5};
        int stocks[] ={7,1,5,3,6,4};
        int newHeights[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        array.pairs(numbers);
        array.subArray(numbers);
        array.findMaxSubArraySum(numbers);
        array.kadanesMaxSubarraySum(numbers);
        array.trappedRainWater(newHeights);
        array.maxProfitforBuySellStock(stocks);
        containerWithMostWater(new int[]{2,3,4,5,18,17,6});
        System.out.println("Max operations "+ maxOperations(new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4},2));

        System.out.println("max avg of a sub array is :"+findMaxAverage(new int[]{-1},1));
        maxVowels("weallloveyou",7);

        System.out.println(array.maximumTripletValue(new int[]{1000000,1,1000000}));
        System.out.println("Get the only number remained from the list after removing kth numbers is "+
                getKthNumber(new ArrayList<>(Arrays.asList(1,2,3,4,5)),3));
    }

    public void pairs(int array[]){
        for(int i=0;i<array.length;i++)
        {
            int curr = array[i];
            for(int j=i+1; j<array.length;j++)
            {
                System.out.print("("+curr+","+array[j]+") ");
            }
            System.out.println();
        }
        System.out.println("Total number of pairs = "+(array.length*(array.length-1)/2));
    }

    //brute force 2 3 4 1 5
    public void subArray(int numbers[]){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_of_sum_subArray =  Integer.MIN_VALUE;
        for(int i=0; i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                int k = i;
                //prefix array will replace this while loop
                while (k<=j){
                    System.out.print(numbers[k]+" ");
                    sum = sum+numbers[k];
                    max = Math.max(max,numbers[k]);
                    min = Math.min(min,numbers[k]);
                    k++;

                }
                max_of_sum_subArray = Math.max(max_of_sum_subArray,sum);
                System.out.print(" Sum of subarray: "+sum);
                System.out.print(" Max of subarray: "+max);
                System.out.print(" Min of subarray: "+min);
                sum=0;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                System.out.println();
            }
            System.out.println("*************");
            System.out.println();
        }
        System.out.println("Total number of subarrays: "+ numbers.length*(numbers.length+1)/2);
        System.out.println("Maximum of the sum of subarray: "+max_of_sum_subArray);
    }

    //prefix sum to find maxsubarray sum
    public void findMaxSubArraySum(int numbers[]){

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_of_sum_subArray =  Integer.MIN_VALUE;

        //stores the sum till the ith index
        int prefix_array[] = new int[numbers.length];
        for(int i = 0; i<numbers.length;i++){
            sum = sum+numbers[i];
            prefix_array[i] = sum;
        }

        for(int i=0; i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
            sum = i == 0? prefix_array[j] : prefix_array[j] - prefix_array[i];
            if(sum>max_of_sum_subArray)
                max_of_sum_subArray = sum;
            }
        }

        System.out.println("Maximum of the sum of subarray using prefix array is: "+max_of_sum_subArray);

    }

    public void kadanesMaxSubarraySum(int numbers[]){
        int currSum =0;
        int maxSum = Integer.MIN_VALUE;

        for(int i =0; i<numbers.length;i++){
            currSum = currSum+numbers[i];
            if(currSum<0)
                currSum =0;

            maxSum = Math.max(maxSum,currSum);
        }
        System.out.println("Maximum of the sum of the sub array using kadanes algorithm: " + maxSum);
    }

    public void trappedRainWater(int height[]){

        int leftMaxBoundary[] = new int[height.length];
        leftMaxBoundary[0] = height[0];
        //setting leftmax boundary for each height element
        for(int i = 1; i< height.length;i++){
            leftMaxBoundary[i] = Math.max(leftMaxBoundary[i-1],height[i]);
        }

        int rightMaxBoundary[] = new int[height.length];
        rightMaxBoundary[rightMaxBoundary.length-1] = height[height.length-1];

        //setting rightmax boundary for each height element
        for (int j = height.length-2; j>=0;j--){
            rightMaxBoundary[j] = Math.max(rightMaxBoundary[j+1],height[j]);
        }

        int trappedwater =0;
        for(int i=0;i<height.length;i++){
            trappedwater = trappedwater + Math.min(leftMaxBoundary[i],rightMaxBoundary[i])-height[i];
        }
        System.out.println("trapped water is "+trappedwater);
    }

    public void maxProfitforBuySellStock(int prices[])
    {
        int selling_price=0;
        int buying_price=Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0;i<prices.length;i++){
            if(buying_price<prices[i])  {
                int profit = prices[i]-buying_price;
                maxProfit = Math.max(maxProfit,profit);
            }
            else{
                buying_price = prices[i];
            }
        }

        System.out.println("maximum price is "+maxProfit);
    }

    public static void containerWithMostWater(int height[]){
        int mostWater=Integer.MIN_VALUE;
        int min;
        int j=height.length-1,i=0;
        while(i<=j){

            min = Math.min(height[i],height[j]);
            mostWater = Math.max(mostWater, min*(j-i));
            if(height[i]<height[j]){
                i++;
            }
            else
            {
                j--;
            }
        }
        System.out.println("Container with most water"+mostWater);
    }

    public static int maxOperations(int nums[], int k){
        int output=0;
        int currSum=0;
        int i=0,j=nums.length-1;
        while(i<j){
            currSum=nums[i]+nums[j];
            if(currSum == k){
                output++;
                i++;
                j--;
            }
            else if(currSum<k){
                i++;
            }
            else{
                j--;
            }
        }
        return output;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double avg, max_avg = Integer.MIN_VALUE;
        double sum=0.0;
        int count,j,pointer;
        for(int i=0;i<nums.length;i++) {
            count = k;
            j=i;
            pointer = j+k-1;
            while (count != 0 && j < nums.length && j<pointer && pointer<nums.length) {
                sum += nums[j]+nums[pointer];
                pointer--;
                j++;
                count=count-2;
            }
            if(count == 1){
                if(j<nums.length){
                    sum=sum+nums[j];
                    count--;
                }
                else if(pointer<nums.length){
                    sum =sum+nums[pointer];
                    count--;
                }
            }
            if (count == 0) {
                avg = sum / k;
                sum = 0.0;
                max_avg = (avg > max_avg) ? avg : max_avg;
            }
            else {
                break;
            }
        }
        return max_avg;

    }

    public static void maxVowels(String s, int k) {
        int count;
        String str="";
        String vowels = "aeiou";
        int maxcount = Integer.MIN_VALUE;
        for(int i=0;i<s.length()&& i+k<=s.length();i++){
            count=0;
            str = s.substring(i,i+k);
            for(int j=0;j<str.length();j++){
                if(vowels.contains(String.valueOf(str.charAt(j)))){
                    count++;
                }
            }
            maxcount = Math.max(count , maxcount);
        }
        System.out.println("Maximum number of vowels in a for a substring of length "+k+" is "+maxcount);

    }

    public long maximumTripletValue(int[] nums) {

        long maxValue = 0;
        long value;
        int k;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                k=j+1;
                while(k<nums.length){
                    value = (nums[i]-nums[j]);
                    value = value * nums[k];
                    if(value>=0)
                        maxValue = Math.max(value,maxValue);
                    k++;
                }
            }
        }
        return maxValue;
    }

    public static int getKthNumber(List<Integer> nums, int k){
        int size = nums.size();
        int i=0;
        int num = nums.get(i);
        int count;
        while(size!=1){
            i =(i+k-1)%size;
            nums.remove(i);
            size = nums.size();
        }
        return nums.get(0);
    }



}