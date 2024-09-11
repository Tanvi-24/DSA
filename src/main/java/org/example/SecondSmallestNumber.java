package org.example;

public class SecondSmallestNumber {
    public static int findSecondSmallestNumber(int []array){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]<smallest){
                smallest = array[i];
            }
            if(array[i]<secondSmallest && array[i] != smallest){
                secondSmallest = array[i];
            }
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        System.out.println("second smallest number in array is "+findSecondSmallestNumber(new int[]{1,5,6,3}));
    }
}
