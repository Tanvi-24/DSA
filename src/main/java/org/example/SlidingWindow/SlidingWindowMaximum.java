package org.example.SlidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {


    static class Pair implements Comparable<Pair>{
        int number;
        int index;

        public Pair(int number,int index){
            this.number = number;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "number=" + number +
                    ", index=" + index +
                    '}';
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.number-this.number;
            //returns largest number
            //sorted in descending order
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3; //size of window
        //n-k+1 number of windows in n sized array
        int result[] = new int[arr.length-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++) {
            pq.add(new Pair(arr[i], i));
        }

        result[0] = pq.peek().number;

        for(int i=k;i<arr.length;i++){
            while (pq.size() > 0 && pq.peek().index <= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i],i));
            result[i-k+1] = pq.peek().number;
        }

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+ " ");
        }


    }
}
