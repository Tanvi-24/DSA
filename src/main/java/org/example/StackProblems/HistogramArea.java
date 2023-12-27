package org.example.StackProblems;

import java.util.Stack;

public class HistogramArea {

    public static int findMaxAreaOfHistogram(int heights[]){
        int nextSmallerLeft[] = new int[heights.length];
        int nextSmallerRight[] = new int[heights.length];

        //find right smaller
        findNextSmallerRight(nextSmallerRight,heights);
        //find left smaller
        findNextSmallerLeft(nextSmallerLeft,heights);
        int maxArea = Integer.MIN_VALUE;
        int currArea;

        //to calculate the area
        for (int i=0;i<heights.length;i++){
            int height = heights[i];
            int width = nextSmallerRight[i]-nextSmallerLeft[i]-1;
            currArea = height*width;
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
    }

    public static void findNextSmallerRight(int nextSmallerRight[],int heights[]){
        Stack<Integer> s = new Stack<>();

        for(int i=nextSmallerRight.length-1;i>=0;i--){

            while (!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }

            if(s.isEmpty()){
                // instead of -1 we are giving size of array to calulate the correct width
                nextSmallerRight[i] = heights.length;
            }
            else {
                //here instead of values we are giving indexes of those values
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);

        }

    }

    public static void findNextSmallerLeft(int nextSmallerLeft[],int heights[]){
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<heights.length;i++){

            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nextSmallerLeft[i] = -1;
            }
            else {
                //here instead of values we are giving indexes of those values
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);

        }

    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println("Max area of a histogram is "+findMaxAreaOfHistogram(heights));
    }
}
