package org.example.binarysearch;
/*
    Ha code ek array madhla peak element (jo neighbors peksha motha asto)
    binary search approach ne efficiently shodhato.
    First ani last elements separately check karto,
    tyat solution asel tar immediately return karto.
    Binary search madhye mid calculate karto,
    jar nums[mid] tyachya neighbors peksha motha asel tar to peak element asto ani return karto.
    Nahitar jar right neighbor motha asel tar right side la move karto, nahi tar left side la move karto.
    Binary search mule optimal solution O(log n) madhye milto.
 */
public class FindPeak {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int start =0 ;
        int end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        int peaksElement[] = {1,12,3,14,5,6,17,8,4};
        FindPeak findPeak = new FindPeak();
        System.out.println(findPeak.findPeakElement(nums));
        System.out.println(findPeak.findPeakElement(peaksElement));
    }
}