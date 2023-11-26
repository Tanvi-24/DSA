package org.example;

import java.util.Arrays;

public class Array {


    public static void main(String args[]){
        Array array = new Array();
        int  numbers[] = {1,-2,6,-1,3};
        int height[] ={4,2,0,6,3,2,5};
        int stocks[] ={7,1,5,3,6,4};
        array.pairs(numbers);
        array.subArray(numbers);
        array.findMaxSubArraySum(numbers);
        array.kadanesMaxSubarraySum(numbers);
        array.trappedRainWater(height);
        array.maxProfitforBuySellStock(stocks);
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
        System.out.println("Maximum of the sum of the sub array using kadanes alogorith: " + maxSum);
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
        int buying_price=prices[0];

        for (int i=1;i<prices.length;i++){
            if(prices[i]<buying_price)
                buying_price = prices[i];

            if(prices[i]>selling_price)
                selling_price = prices[i];

        }

        int profit = selling_price-buying_price;

        if(profit<=0)
            System.out.println("profit is 0");
        else
            System.out.println("profit is "+profit);
    }
}