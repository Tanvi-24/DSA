package org.example.binarysearch;

import java.util.Arrays;

/*You are given two positive integer arrays spells and potions, of length n and m respectively,
where spells[i] represents the strength of the ith spell and potions[j] represents the strength
of the jth potion.
You are also given an integer success. A spell and potion pair is considered successful,
if the product of their strengths is at least success.
Return an integer array pairs of length n where pairs[i] is the number of potions that will form a
successful pair with the ith spell.*/

/*
    Given two arrays: spells (each spell cha strength) ani potions (each potion cha strength).
    Ek success number dilela aahe; jar spell cha strength × potion cha strength ≥ success,
    tar toh pair successful aahe.
    First, potions array sort kelay,
    ani binary search use karun each spell sathi count karto ki kiti potions successful pair banavtat.
    Binary search madhun minimum index milto jo successful pair banavto;
    tya index pasun end paryant sagle successful astat; tyacha count store karun result array madhye takto.
    Hyamule result efficiently milto (O(n log m) complexity), jithe n spells ani m potions aahet.
 */
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
