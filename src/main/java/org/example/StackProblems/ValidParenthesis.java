package org.example.StackProblems;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch =='(' || ch == '[' || ch == '{'){
                s.push(ch);
            }
            else {
                //closing bracket
                if(s.isEmpty())
                    return false;

                if(s.peek() == '(' && ch ==')'
                        || s.peek() =='{' && ch == '}'
                        || s.peek() == '[' && ch == ']'){
                    s.pop();
                }
                else {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static boolean isValidParenthesis1(String str){
        Stack<Character> s = new Stack<>();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            switch (c){
                case '{':
                    s.push('}');
                    break;
                case '[':
                    s.push(']');
                    break;
                case '(':
                    s.push(')');
                    break;
                default:
                    if(s.isEmpty() || s.pop() != c) {
                        return false;
                    }

            }
        }
        return s.isEmpty();

    }

    public static boolean duplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                }
                else {
                    s.pop();
                }

            }
            else {
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {

        String str = "({[]}())";
        System.out.println(isValidParenthesis1(str));
        System.out.println(isValid(str));
        String s = "((a+b))";
        System.out.println("is string with duplicate parenthesis: "+ duplicateParenthesis(s));
    }
}
