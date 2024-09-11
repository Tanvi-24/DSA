package org.example.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {

        Queue<Character> queue = new LinkedList<>();
        List<Character> list = new ArrayList<>();
        queue.add(s.charAt(0));
        list.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == queue.peek()){
                queue.poll();
            }
            else{
                if(!list.contains(s.charAt(i))){
                    queue.add(s.charAt(i));
                    list.add(s.charAt(i));
                }
                else if(queue.contains(s.charAt(i))){
                    while(!queue.isEmpty() && queue.peek()!=s.charAt(i)){
                        char c = queue.poll();
                        queue.add(c);
                    }
                    if(!queue.isEmpty() && queue.peek() == s.charAt(i)){
                        queue.poll();
                    }
                }

            }
        }
        if(!queue.isEmpty())
            return s.indexOf(queue.peek());

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("loveleetcodev"));
    }
}
