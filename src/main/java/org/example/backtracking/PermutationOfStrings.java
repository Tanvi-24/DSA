package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    - **PermutationsOfStrings** madhe ek string (`"abc"`) che **sagle possible permutations**
     generate kele ahet (jase ki "abc", "acb", "bac", etc.).

    - Recursive function `findPermutation()` madhye ek-ek character (`curr`) string madhun kadhun tyala
    `ans` la jodto ani pudhchi recursion call karto, baki urlelya string sobat.

    - Base case (`str.length()==0`) la pohochlyavar ek permutation tayar zaleli aste,
     ji `list` madhye store karun print keli jate.

    - Ha method backtracking cha use karun sagle permutations efficiently generate karto,
     hyachi complexity `O(n * n!)` aste.
 */
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
