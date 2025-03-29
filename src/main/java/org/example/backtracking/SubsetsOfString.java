package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
    SubsetsOfString madhe ek given string ("abc") che sagle possible subsets generate kele ahet
    (example: "", "a", "b", "c", "ab", "bc", "abc" etc.).
    Recursive method (subSets) madhye pratyek character sathi don choices astat:
    "yes choice": character subset madhye include karto.
    "no choice": character subset madhye include karat nahi.
    Base case madhe (i == length) ek subset generate zala ki to print karun result array madhe store karto.
    Ek improved method (subSetsUsingSb) madhe mutable StringBuilder cha use kela ahe,
     jyane backtracking ani recursion la efficient banavto (string madhun character delete karun
     backtrack karto).
    He sagle subsets generate karnyacha approach recursive ani backtracking var based aahe;
    complexity O(n * 2^n) aste.
 */
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
