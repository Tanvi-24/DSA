package org.example.StackProblems;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Predicate;

public class AsteroidsCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){

            if((stack.peek()<0 && asteroids[i]<0) ||
                    stack.peek()>=0 && asteroids[i]>=0)      {

                stack.push(asteroids[i]);
            }

            else{
                if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                    stack.pop();
                }
                else{
                    while (!stack.isEmpty()&& Math.abs(stack.peek()) <= Math.abs(asteroids[i])){
                        stack.pop();

                        if((stack.peek()<0 && asteroids[i]<0) ||
                                stack.peek()>=0 && asteroids[i]>=0)      {

                            stack.push(asteroids[i]);
                        }
                        else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                            stack.pop();
                        }
                    }
                }
            }
        }

        int i = stack.size() - 1;
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i--;
        }

        return result;
    }
    public static void main(String[] args) {

        int []asteroids = {-2,-2,2,-2};
        int result[] = asteroidCollision(asteroids);
        Arrays.stream(result).forEach(System.out::println);
        Stack<Integer> stack = new Stack<>();

//        for (int i = 0; i < asteroids.length; i++) {
//            if (asteroids[i] < 0) {
//                if (stack.isEmpty() || stack.peek() < 0) {
//                    stack.push(asteroids[i]);
//                } else {
//                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(asteroids[i])) {
//                        stack.pop();
//                    }
//                    if (!stack.isEmpty() && stack.peek() < 0) {
//                        if (asteroids[i] == stack.peek()) {
//                            continue;
//                        }
//                        if (asteroids[i] <= stack.peek()) {
//                            stack.push(asteroids[i]);
//                        }
//                    }
//                }
//            } else {
//                stack.push(asteroids[i]);
//            }
//        }
//        int i = stack.size() - 1;
//        int[] result = new int[stack.size()];
//        while (!stack.isEmpty()) {
//            result[i] = stack.pop();
//            i--;
//        }


    }
}
