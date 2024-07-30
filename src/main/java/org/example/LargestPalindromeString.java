package org.example;

import java.util.ArrayList;
import java.util.List;

public class LargestPalindromeString {
    public static String longestPalindrome(String s) {

        String palindrome= "";
        List<String> str = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(isPalindrome(new StringBuilder(s.substring(i,j)))){
                    if(!palindrome.isEmpty()) {
                        if (palindrome.length() < s.substring(i, j).length()) {
                            palindrome = s.substring(i, j);
                        }
                    }
                    else{
                        palindrome = s.substring(i,j);
                    }
                }
            }
        }

        return palindrome;

    }

    public static boolean isPalindrome(StringBuilder s){
        StringBuilder reverse = new StringBuilder(s);

        return s.compareTo(reverse.reverse()) == 0;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abb"));
    }
}
