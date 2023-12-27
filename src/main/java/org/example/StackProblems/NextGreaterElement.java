package org.example.StackProblems;

import java.util.Stack;

public class NextGreaterElement {
    public static void findNextGreater(int arr[],int nextGreater[]){
        Stack<Integer> s = new Stack<>();

       //this loop is for right greater element
        //to get left greater change the loop direction
        for(int i=arr.length-1;i>=0;i--){

            //remove smaller elements
            //to get next smaller reverse the condition to check the element
            while (!s.isEmpty() && arr[s.peek()]<=arr[i])
            {
             s.pop();
            }

            //if else to add next greater for each element
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }
            else {
             nextGreater[i] = arr[s.peek()];
            }

            //push index of element which is greater
            s.push(i);
        }

    }

    public static void findNextGreaterFromLeft(int arr[],int nextGreaterLeft[]){
        Stack<Integer> s = new Stack<>();

        //this loop is for right greater element
        //to get left greater change the loop direction
        for(int i=0;i<arr.length;i++){

            //remove smaller elements
            //to get next smaller reverse the condition to check the element
            while (!s.isEmpty() && arr[s.peek()]<=arr[i])
            {
                s.pop();
            }

            //if else to add next greater for each element
            if(s.isEmpty()){
                nextGreaterLeft[i] = -1;
            }
            else {
                nextGreaterLeft[i] = arr[s.peek()];
            }

            //push index of element which is greater
            s.push(i);
        }

    }

    public static void findNextSmaller(int arr[],int nextSmaller[]){
        Stack<Integer> s = new Stack<>();

        //this loop is for right greater element
        //to get left greater change the loop direction
        for(int i=arr.length-1;i>=0;i--){

            //remove greater elements
            //to get next greater reverse the condition to check the element
            while (!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }

            //if else to add next smaller for each element
            if(s.isEmpty()){
                nextSmaller[i] = -1;
            }
            else {
                nextSmaller[i] = arr[s.peek()];
            }

            //push index of element which is smaller
            s.push(i);
        }

    }

    public static void findNextSmallerFromLeft(int arr[],int nextSmallerLeft[]){
        Stack<Integer> s = new Stack<>();

        //this loop is for right greater element
        //to get left greater change the loop direction
        for(int i=0;i<arr.length;i++){

            //remove greater elements
            //to get next greater reverse the condition to check the element
            while (!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }

            //if else to add next smaller for each element
            if(s.isEmpty()){
                nextSmallerLeft[i] = -1;
            }
            else {
                nextSmallerLeft[i] = arr[s.peek()];
            }

            //push index of element which is smaller
            s.push(i);
        }

    }
    public static void print(int[] nextGreater) {
        for (int j : nextGreater) {
            System.out.print(j+ " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int nextGreater[] = new int[arr.length];
        int nextSmaller[] = new int[arr.length];
        int nextSmallerLeft[] = new int[arr.length];
        int nextGreaterLeft[] = new int[arr.length];

        System.out.println("The given array is ");
        print(arr);

        System.out.println();
        System.out.println("print arr with next greatest ");
        findNextGreater(arr,nextGreater);
        print(nextGreater);

        System.out.println();
        System.out.println("print arr with next smallest ");
        findNextSmaller(arr,nextSmaller);
        print(nextSmaller);

        System.out.println();
        findNextSmallerFromLeft(arr,nextSmallerLeft);
        System.out.println("print arr with next smallest from left ");
        print(nextSmallerLeft);

        System.out.println();
        findNextGreaterFromLeft(arr,nextGreaterLeft);
        System.out.println("print arr with next greatest from left ");
        print(nextGreaterLeft);
    }

}
