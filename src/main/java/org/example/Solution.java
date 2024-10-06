package org.example;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int array[] = {2,4,1,2,7,8};
       System.out.println(maxCoins(array));
        int numsp[] = {20,100,10,12,5,13};
       String str =  findGcdoFString("CCCAAAAAA","CCC");
        System.out.println("GCD of above strings is "+str);
        System.out.println(reversedString("the sky   is blue"));
        System.out.println(isIncreasingTriplet(numsp));
        List<String> strList = new ArrayList<>();
        strList.add("one.two.three");
        strList.add("four.five");
        List<String> result = splitWordsBySeparator(strList,'.');
        System.out.println(result);
    }
    public static int maxCoins(int[] piles) {
        // 2 4 1 2 7 8
        //after sort
        // 1 2 2 4 7 8
        // 0 1 2 3 4 5
        Arrays.sort(piles);
        int sum=0;
        for(int i=piles.length-1;i>0;i=i-3){

            sum=sum+piles[i-1];

        }
        return sum;
    }

    public static String findGcdoFString(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        int gcd = gcd(len1,len2);
        System.out.println("gcd value " +gcd);
        int index=0;
        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);
        boolean isgcd = true;
        String s1="",s2="";

        while (sb1.length() != 0 && sb2.length()!=0) {
            s1 = sb1.substring(index, gcd);
            s2 = sb2.substring(index, gcd);
            if (!(s1.equals(s2))) {
                isgcd = false;
                break;
            }
            sb1.delete(index, gcd);
            sb2.delete(index,gcd);
        }

        if(!isgcd)
            return "";
        else {
            if(sb1.length()!=0){
                while (sb1.length()!=0) {
                    if (!s1.equals(sb1.substring(index, gcd))) {
                        isgcd = false;
                        break;
                    }
                }
            }
            else if(sb2.length()!=0){
                while (sb2.length()!=0) {
                    if (!s2.equals(sb2.substring(index, gcd))) {
                        isgcd = false;
                        break;
                    }
                }
            }
        }
        if(isgcd)
        {
            return s1;
        }
        else return "";

    }

    public static int gcd(int a, int b)
    {
        // Find Minimum of a and b
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }

        // Return gcd of a and b
        return result;
    }

    public static String reversedString(String s){
        Stack<String> stack = new Stack<>();
        int j=0,i;
        for(i=0;i<s.length();i++){

            if(s.charAt(i) == ' '){
                String str = s.substring(j,i);
                if(!str.trim().isEmpty()) {
                    stack.push(s.substring(j, i).trim());
                    j = i + 1;
                }
            }
        }
        String temp = s.substring(j,i);
        if(!temp.trim().isEmpty()) {
            stack.push(s.substring(j, i));
        }

        System.out.println(stack);
        String result="";
        while (!stack.isEmpty()){
            result = result+stack.pop()+" ";
        }
        return result.trim();
    }

    public static boolean isIncreasingTriplet(int[] nums){
        boolean triplet = false;
        int i,j;
        for(i=0,j=i+1;i<nums.length && j<nums.length;i++,j++){

            if(nums[i]<nums[j]){
                int k=j+1;
                while(k<nums.length){
                    if(nums[j]<nums[k]){
                        triplet = true;
                        break;
                    }
                    k++;
                }

            }
        }
        return triplet;
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for(int i=0;i<words.size();i++){
            String str = words.get(i);
            String arr[] = str.split("\\.");
            for(int j=0;j<arr.length;j++){
                result.add(arr[j]);
            }
        }

        return result;
    }
}

