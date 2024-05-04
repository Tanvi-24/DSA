package org.example;

public class DayOne {
    public static void main(String[] args) {
        System.out.println(ReverseNumber(102033));
        System.out.println(reverseString("OmkarGaikwad"));
//        printFib(10);

        printFibonacciSeries(12);
    }

    public static int ReverseNumber(int n) {
        int number = n;
        int reverseNumber = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            number = number / 10;
        }
        return reverseNumber;
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean isPartOfFibonacci(int n) {
        int a = 0;
        int b = 1;
        if (n == 0 || n == 1) {
            return true;
        }
        int fib = a + b;
        while (fib <= n) {
            if (fib == n) {
                return true;
            }
            a = b;
            b = fib;
            fib = a + b;
        }
        return false;
    }

    public static int Fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fib = Fib(n - 1) + Fib(n - 2);
        return fib;
    }

    public static void printFib(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(Fib(i));
        }
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void printFibonacciSeries(int count) {
        int num1 = 0, num2 = 1;
        System.out.print(num1 + " " + num2 + " ");
        for (int i = 2; i < count; i++) {
            int nextNum = num1 + num2;
            System.out.print(nextNum + " ");
            num1 = num2;
            num2 = nextNum;
        }
    }

}
