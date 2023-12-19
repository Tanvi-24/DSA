package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfString {

    public static void main(String[] args) {
        String str ="abc";
        List<String> strarray = new ArrayList<>();
        subSets(str,"",0,strarray);
        subSetsUsingSb(str, new StringBuilder(),0);
        System.out.println(strarray+" length of list is "+strarray.size());
    }

    public static void subSets(String str, String ans, int i,List strArray){

        //base case
        if(i == str.length()){
            System.out.println(ans);
            strArray.add(ans);
            return;
        }
        //recursion

        //yes choice
        subSets(str, ans+str.charAt(i), i+1,strArray);
        //no choice
        subSets(str,ans,i+1,strArray);

        //time complexity = O(n * 2^n) space complexity = O(n)
        //if we have n chars total susbsets is 2^n
        //since we have two choices

    }

    public static void subSetsUsingSb(String str, StringBuilder ans, int i){

        //base case
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        //recursion

        //yes choice
        subSetsUsingSb(str, ans.append(str.charAt(i)), i+1);
        ans.deleteCharAt(ans.length()-1);
        //no choice
        subSetsUsingSb(str,ans,i+1);

        //time complexity = O(n * 2^n) space complexity = O(n)
        //if we have n chars total susbsets is 2^n
        //since we have two choices

    }
}
