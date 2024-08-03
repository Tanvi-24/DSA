package org.example.GreedyAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class IsFairMatch {

    public static boolean isFairMatch(int[] array){
        Map<Integer,Integer> map = new HashMap<>();
        int j=array.length;

        if(array.length == 1){
            return true;
        }

        for(int i=0;i<array.length && j>0;i++,j--){
            map.put(i+1,j);
        }

        j=0;
        int []newArray = new int[array.length/2];
        for(int i=0;i<array.length;i=i+2){

            if(map.get(array[i]) != array[i+1]){
                return false;
            }

            newArray[j] = Math.min(array[i],array[i+1]);
            j++;
        }

        return isFairMatch(newArray);
    }

    public static boolean isFairMatch2(int arr[]){
        if(arr.length == 1){
            return true;
        }
        int length = arr.length+1;
        int newArray[] = new int[arr.length/2];
        int j=0;

        for(int i=0;i<arr.length;i=i+2){
            if(arr[i]+arr[i+1]!=length){
                return false;
            }
            newArray[j] = Math.min(arr[i],arr[i+1]);
            j++;
        }
        return isFairMatch(newArray);

    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,3}; //fair match {1,2,3,4} - //not fair
        int arr2[] = {1,8,4,5,2,7,3,6}; //fair match
        int arr3[] = {1,8,2,7,3,6,4,5}; //unfair match
        System.out.println(isFairMatch(arr));
        System.out.println(isFairMatch(arr3));
        System.out.println(isFairMatch2(arr));
        System.out.println(isFairMatch2(arr3));
    }
}

