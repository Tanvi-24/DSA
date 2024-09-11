package org.example.SlidingWindow;

import java.util.Arrays;

public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);

        for(int i=0;i<=s2Array.length-s1Array.length;i++){
            char []subArray = Arrays.copyOfRange(s2Array,i,i+s1Array.length);
            Arrays.sort(subArray);

            if(Arrays.equals(subArray,s1Array)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
        System.out.println(checkInclusion("adc","dcda"));
    }
}
