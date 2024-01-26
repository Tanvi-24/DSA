package org.example.StackProblems;

import java.util.Stack;

class DecodeString {
    public static String decodeString(String s) {
        String str=""; //3[z]2[2[y]pq4[2[jk]e1[f]]]ef
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch ==']'){
                String t="";
                while(!stack.peek().equals("["))
                {
                    t=t+stack.pop();
                }
                if(stack.peek().equals("[")){
                    stack.pop();
                    StringBuilder sb = new StringBuilder(t);
                    t = sb.reverse().toString();
                    int num = Integer.parseInt(stack.pop());
                    String temp ="";
                    for(int j=0; j<num; j++){
                        temp+=t;
                    }
                    stack.push(temp);
                }

            }
            else if(Character.isDigit(ch)){
                if(!stack.isEmpty() && stack.peek().matches("\\d+")){
                    stack.push(stack.pop()+ch);
                }
                else{
                    stack.push(String.valueOf(ch));
                }
            }
            else{
                stack.push(String.valueOf(ch));
            }
        }

        String [] strarr = new String[stack.size()];
        int i=stack.size()-1;
        while (!stack.isEmpty()){
         strarr[i] = stack.pop();
         i--;
        }
        String s1="";

        for(int k=0;k<strarr.length;k++){
            s1+=strarr[k];
        }
        return s1;
    }

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("10[a]20[bc]"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        //zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef

    }
}