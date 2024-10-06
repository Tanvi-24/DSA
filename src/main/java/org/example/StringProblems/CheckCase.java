package org.example.StringProblems;

import java.util.HashSet;

public class CheckCase {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1){
            return true;
        }

        String upper = word.toUpperCase();
        String lower = word.toLowerCase();
        String capitalize = Character.toUpperCase(lower.charAt(0))+lower.substring(1);
        System.out.println(capitalize);
        if(word.equals(upper) || word.equals(lower)|| word.equals(capitalize)){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        CheckCase checkCase = new CheckCase();
        System.out.println(checkCase.detectCapitalUse("USA"));
    }

    HashSet<String> set;
}