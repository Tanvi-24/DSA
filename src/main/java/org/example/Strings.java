package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Strings
{

    public static void main(String[] args) {

        /*Given a route containing four directions(E W N S) find the shortest path to reach
        the destionation*/
        String str = "WNEENESENNN";
        shortestPath(str);

        //find largest string lexicographically
        System.out.println("largest is "+largestString());

        //convert string to uppercase
        System.out.println("String in upper case is : "+convertEachWordFirstLetterToUpperCase("hi i am tanvi"));

        //compress the given string
        String newstr = compressString("aaabbcccdd");
        System.out.println("The given string is compressed to "+newstr);
        char []chars={'a','b','c'};
        System.out.println(compressCharArray(chars));
        moveZeroes(new int[]{1,1,0,2,3});
        System.out.println("\nis the string panagram "+checkIfPangram("leetcode"));

        String input = "aabbbbbccddb";
        int[] result = longestIdenticalSubstring(input);
        System.out.println("Input String: " + input);
        System.out.println("Start index and length of the longest substring with identical characters: " + Arrays.toString(result));

    }
    public static void shortestPath(String path){
        int x=0,y=0;
        for (int i=0;i<path.length();i++) {
            char dir = path.charAt(i);
            if (dir == 'E')
                x += 1;
            else if (dir == 'W')
                x -= 1;
            else if (dir == 'N')
                y += 1;
            else
                y -= 1;

        }
        double shortestPath = Math.sqrt((x*x)+(y*y));
        System.out.println("shortest path for the given directions is : "+shortestPath);
    }

    public static String largestString(){
        String fruits[] = {"apple","cherry","banana"};
        String largest=fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(fruits[i].compareToIgnoreCase(largest)>0)
                largest = fruits[i];
        }
        return largest;
    }

    public static String convertEachWordFirstLetterToUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
//        sb.append(Character.toUpperCase(str.charAt(0)));
        String[] arr = str.split(" ");
        for (String s:arr) {
            sb.append(Character.toUpperCase(s.trim().charAt(0)));
            sb.append(s.substring(1));
            sb.append(" ");
        }
       /* for (int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i < str.length() - 1) {
                    sb.append(str.charAt(i));
                    i++;
                    sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else
                sb.append(str.charAt(i));

        }*/
        return sb.toString();
    }

    public static String compressString(String str){

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++){
            int count=1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1)
                sb.append(count);
        }
        return sb.toString();
    }

    public static int compressCharArray(char[] chars){
        int count =1;
        String s="";

        if(chars.length == 1)
            return 1;

        for(int i=0;i<chars.length;i++){
            if(i<chars.length-1 && chars[i]!=chars[i+1]){
                s=s+chars[i];
                if(count!=1)
                {
                    s=s+count;
                }
                count=1;
            }
            else if(i==chars.length-1){
                s=s+chars[i];
                if(count!=1){
                    s=s+(count-1);
                }
            }
            else{
                count++;
            }
        }

        return s.length();
    }

    public static void moveZeroes(int[] nums) {
        int i,j=0,count=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                if(i!=j)
                {
                    nums[i]=0;
                }
                j++;
            }
        }
        System.out.println("nums array after moving zeros is ");
        for (int n:nums) {
            System.out.print(n+" ");
        }
    }

    public static boolean checkIfPangram(String sentence) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        int j=0;
        for(int i=0;i<str.length();i++)
        {
            if(!sentence.contains(String.valueOf(str.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    public static int[] longestIdenticalSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return new int[]{};
        }

        int start = 0;
        int maxStart = 0;
        int length = 1;
        int maxLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                    maxStart = start;
                }
                start = i;
                length = 1;
            }
        }

        // Check the last substring
        if (length > maxLength) {
            maxStart = start;
            maxLength = length;
        }

        return new int[]{maxStart, maxLength};
    }



}
