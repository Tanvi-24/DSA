package org.example.StringProblems;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//construct string with repeat limit lexicographically
public class StringWithRepeatLimit {
    public static String repeatLimitedString(String s, int repeatLimit) {
        Map<Character,Integer> charCount = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<s.length();i++){
            charCount.put(s.charAt(i),charCount.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder("");
        List<Character> list = charCount.keySet().stream().sorted(Comparator.reverseOrder()).toList();

//zzcccac
        for(int i=0;i<list.size();i++){
            if(charCount.get(list.get(i))<=repeatLimit){
                String ch = Character.toString(list.get(i));
                sb.append(ch.repeat(charCount.get(list.get(i))));
            }
            else{
                String ch = Character.toString(list.get(i));
                sb.append(ch.repeat(repeatLimit));
                charCount.put(list.get(i),charCount.get(list.get(i))-repeatLimit);
                int j = i+1;
                int currCharCount = charCount.get(list.get(i));
                while(currCharCount>0 && j<list.size()){
                    if(charCount.get(list.get(j))>0 && j<list.size()){
                        sb.append(list.get(j));
                        charCount.put(list.get(j),charCount.get(list.get(j))-1);
                        sb.append(ch.repeat(Math.min(repeatLimit,currCharCount)));
                        currCharCount = charCount.get(ch.charAt(0))-Math.min(repeatLimit,currCharCount);
                        charCount.put(ch.charAt(0),currCharCount);
                    }
                    if(charCount.get(list.get(j))==0){
                        j++;
                    }
                }
                //i=j;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(repeatLimitedString("ccazzacc",3));
        System.out.println(repeatLimitedString("aababab",2));
    }
}
