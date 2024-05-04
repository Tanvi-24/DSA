package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfStrings {
    public static void main(String[] args) {
        String str = "abc";
        List<String> list = new ArrayList<>();
        findPermutation(str,"",list);
        System.out.println(list);
    }

    public static void findPermutation(String str, String ans,List<String> list){
        if(str.length() == 0)
        {
            System.out.println(ans);
            list.add(ans);
        }

        for (int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newString = str.substring(0,i)+str.substring(i+1);
            findPermutation(newString,ans+curr,list);
        }
        //time complexity O(n*n!)

    }
}
