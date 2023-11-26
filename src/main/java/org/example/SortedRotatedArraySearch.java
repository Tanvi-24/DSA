package org.example;

public class SortedRotatedArraySearch {

    public static void main(String[] args) {
        int array[] ={4,5,6,7,0,1,2,3};
        int target =8;

        int index = search(array,target,0,array.length-1);
        System.out.println("Index of target "+target+" is "+index);
    }

    public static int search(int array[], int target, int start,int end){
        if(start>end)
            return -1;

        int mid = start+(end-start)/2;
        //case found
        if(array[mid] == target)
            return mid;

        // mid on line 1
        if(array[start]<=array[mid]){
            if(array[start]<=target && target<=array[mid])
            {
                return search(array,target,start,mid-1);
            }
            else {
              return  search(array,target,mid+1,end);
            }
        }
        //mid on line 2
        else{
            if(array[mid]<=target && target<=array[end]){
                return search(array,target,mid+1,end);
            }
            else {
                return search(array,target,mid-1,start);
            }
        }
    }
}
