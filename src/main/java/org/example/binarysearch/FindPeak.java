package org.example.binarysearch;

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
        FindPeak findPeak = new FindPeak();
        System.out.println(findPeak.findPeakElement(nums));
    }
}