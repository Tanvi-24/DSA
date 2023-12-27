package org.example.StackProblems;

import java.util.Stack;

public class StacksEx {

    public static void pushAtBottom(Stack<Integer> s, int data){
        //push data at bottom
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    public static  void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }

    public static void printStack(Stack s){
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        System.out.println("Push 4 at bottom");
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s,4);
        System.out.println(s);
        printStack(s);
        System.out.println("Reverse a stack");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack(stack);
        System.out.println(stack);;
        printStack(stack);

    }
}
