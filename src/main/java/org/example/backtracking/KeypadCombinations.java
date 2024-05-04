package org.example.backtracking;

import java.util.HashMap;
import java.util.Map;

public class KeypadCombinations {
    public static void main(String[] args) {
        Map<Integer,String> digitsMap = new HashMap<>();
        digitsMap.put(2,"abc");
        digitsMap.put(3,"def");
        digitsMap.put(4,"ghi");
        digitsMap.put(5,"jkl");
        digitsMap.put(6,"mno");
        digitsMap.put(7,"pqrs");
        digitsMap.put(8,"tuv");
        digitsMap.put(9,"wxyz");
        String digits ="67";
        findCombinations(digits,digitsMap);
    }

    public static void findCombinations(String digits, Map<Integer,String> digitsMap){
        if(digits.length()==1){
            String str = digitsMap.get(Integer.parseInt(digits));
            for (int i=0;i<str.length();i++){
                System.out.print(str.charAt(i)+" ");
            }
        }
        else {
            backtrackingSol(digitsMap.get(Integer.parseInt(String.valueOf(digits.charAt(0)))),
                    digitsMap.get(Integer.parseInt(String.valueOf(digits.charAt(1)))));
        }
    }

    public static void backtrackingSol(String str1,String str2){
        for(int i=0; i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                System.out.print(String.valueOf(str1.charAt(i))+String.valueOf(str2.charAt(j)) + " ");
            }
            System.out.println();
        }
    }

}
