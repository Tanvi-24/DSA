package org.example.StringProblems;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//construct string with repeat limit lexicographically
public class StringWithRepeatLimit {
    public static String repeatLimitedString(String s, int repeatLimit) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int []arr = new int[26];
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<=repeatLimit){
                String a = Character.toString(alphabet.charAt(i));
                str.append(a.repeat(arr[i]));
            }else{
                String a = Character.toString(alphabet.charAt(i));
                str.append(a.repeat(repeatLimit));
                arr[i]-=repeatLimit;
                int j = i-1;
                while(arr[i]>0&&j>=0){
                    if(arr[j]>0){
                        str.append(alphabet.charAt(j));
                        arr[j]--;
                        str.append(a.repeat(Math.min(repeatLimit, arr[i])));
                        arr[i]-=Math.min(repeatLimit, arr[i]);
                    }
                    if(arr[j]==0)
                        j--;
                }
                i=j+1;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
       // System.out.println(repeatLimitedString("ccazzacc",3));
        System.out.println(repeatLimitedString("aababab",2));
    }
}
