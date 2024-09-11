package org.example.binarysearch;

import java.util.Arrays;

public class SuccessCount {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int successArr[] = new int[spells.length];

            Arrays.sort(potions);
            for(int i=0;i<spells.length;i++){
                successArr[i] = potions.length-getSuccessCount(spells[i],potions,success);
            }

            return successArr;
        }

    public int getSuccessCount(int spell, int potions[], long success){

        int start = 0, end = potions.length;
        while(start<end){
            int mid = start+(end-start)/2;
            //calculate the long strength
            if(spell*1l*potions[mid]>=success){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        int spells[]={5,1,3};
        int potions[] = {1,2,3,4,5};
        SuccessCount sc = new SuccessCount();
        int success[] = sc.successfulPairs(spells,potions,7);
        Arrays.stream(success).forEach(System.out::println);

    }
}
