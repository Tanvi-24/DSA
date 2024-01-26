package org.example.Graphs;

public class CalculateCycleLength {

    public static int getLengthOfCycle(int array[], int startIndex){

        int i = array[startIndex];
        // 1 2 0
        // 0 1 2

        if(startIndex>array.length){
            return -1;
        }

        int count = 0;
        while (i<array.length) {
            if ( i == startIndex) {
                return count+1;
            }
            else {
                count++;
                i = array[i];
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int array[] = {1,2,4,0};
        System.out.println("Length of cycle is " +getLengthOfCycle(array,1));
    }
}
