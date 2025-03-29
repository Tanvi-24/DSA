package org.example.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    Code madhye mobile keypad varil digits (2-9) sathi possible letter combinations generate karle ahet.
    Ek digitsMap madhye digits ani tyanchi corresponding letters store kele ahet.
    findCombinations method madhye simple approach ahe; fakt don digits ghyun tyanchya combinations
    nested loops (backtrackingSol) vaprun generate ani print kele ahet.
    Generalized method findCombinationsBacktracking backtracking ani recursion vaprun
    multiple digits sathi suddha combinations create karto.
    Ek-ek digit che letters pick karun recursive call karto ani
    final combinations result list madhe store karto.
    He generalized recursive method (findCombinationsBacktracking) effective ani scalable aahe,
    jyane tumhi 2 peksha jast digits che pan combinations shodhushakta.
 */
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
        List<String> result = new ArrayList<>();
        findCombinationsBacktracking(digits, digitsMap, 0, "", result);
        System.out.println(result);
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
    public static void findCombinationsBacktracking(String digits, Map<Integer, String> digitsMap,
                                                    int index, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = digitsMap.get(digits.charAt(index) - '0');
        for (char c : letters.toCharArray()) {
            findCombinationsBacktracking(digits, digitsMap, index + 1, current + c, result);
        }
    }
}
