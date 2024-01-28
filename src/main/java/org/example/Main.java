package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int n = 16;
        System.out.println("factorial of " + n + " is: " + m.findFactorialByRecursion(n));
        System.out.println(n + " is prime / not prime: " + m.isPrimeOptimized(n));
        System.out.println("print primes for range " + n);
        m.printPrimesInRange(n);
        System.out.println("\nBinary to decimal of 101");
        m.printBinaryToDecimal(101);
        System.out.println(m.printBinaryToDecRecursion(101, 0, 0));
        System.out.println("print dec to binary conversion of 5: ");
        System.out.println(m.printDecToBinaryByRec(5, 0, 0));

        int num[] = {1, 2, 6, 4, 5};
        //getNthfibonnaci
        System.out.println("Nth fibonacci number is " + m.getNthFibonacciNumber(5));

        //check if the array is sorted
        System.out.println("is Array sorted : " + (isSorted(num, 0) ? "yes" : "no"));

        int array[] = {1, 4, 2, 5, 7, 2, 6, 5, 8};
        //get first occurence of key in array
        System.out.println("first occurence for 5 " + firstOccurence(num, 5, 0));

        //get last occurence of key in array
        System.out.println("last occurence for 5 is at " + lastOccurence(array, 5, 0) + " position");

        System.out.println(optimixedPower(5, 3));

        //get totol number of way to fill 2 x n space with 2 x 1 tiles
        int b = 5;
        System.out.println("Total number of ways to fill 2 x " + b + " space with 2 x 1 tiles is " + m.tillingProblem(b));

        String str = "appnnaacolllegge";
        //remove duplicates in a string
        removeDuplicates(str, new StringBuilder(), 0, new boolean[26]);

        int friends = 4;
        //with recursion
        System.out.println("Friends Pairing for " + friends + " is: " + friendsPairingWays(friends));

        System.out.println("Binary number of length N\n");
        //print binary number for length N
        printBinNumbers(3,0,"");
        System.out.println("\nBinary number of length N and without consecutive 1's ");
        //print binary number for length N without having consecutive 1's
        printBinNumbers2(3,0,"");
    }

    public int findFactorialByRecursion(int n) {
        if (n == 1)
            return 1;
        else
            return n * findFactorialByRecursion(n - 1);
    }

    public boolean isPrime(int n) {
        boolean isPrime = true;
        if (n == 2)
            return isPrime;
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public boolean isPrimeOptimized(int n) {
        boolean isPrime = true;
        if (n == 2)
            return isPrime;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                return isPrime;
            }
        }
        return isPrime;
    }

    public void printPrimesInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrimeOptimized(i))
                System.out.print(i + " ");
        }
    }

    public void printBinaryToDecimal(int n) { //101
        int bit;
        int count = 0;
        int dec = 0;
        while (n > 0) {
            bit = n % 10;
            n = n / 10;
            dec = dec + bit * (int) Math.pow(2, count);
            count++;
        }
        System.out.println(dec);
    }

    public int printBinaryToDecRecursion(int n, int count, int dec) {
        if (n == 0)
            return dec;
        else {
            int bit = n % 10;
            dec = dec + bit * (int) Math.pow(2, count);
            count++;
            n = n / 10;
            return printBinaryToDecRecursion(n, count, dec);
        }

    }

    public int printDecToBinaryByRec(int n, int count, int bin) {
        if (n == 0)
            return bin;
        else {
            int num = n % 2;
            bin = bin + num * (int) (Math.pow(10, count));
            count++;
            n = n / 2;
            return printDecToBinaryByRec(n, count, bin);
        }
    }


    //time complexity is O(2^n)
    //space complexity is O(n)
    public int getNthFibonacciNumber(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fib1 = getNthFibonacciNumber(n - 1);
        int fib2 = getNthFibonacciNumber(n - 2);
        int fibN = fib1 + fib2;
        return fibN;
    }


    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1)
            return true;
        if (arr[i] > arr[i + 1])
            return false;
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int array[], int key, int i) {

        if (i == array.length) {
            return -1;
        }

        if (array[i] == key)
            return i;

        return firstOccurence(array, key, i + 1);
    }

    public static int lastOccurence(int array[], int key, int i) {

        if (i == array.length)
            return -1;
        int isFound = lastOccurence(array, key, i + 1);

        if (isFound == -1 && array[i] == key)
            return i;

        return isFound;
    }

    public static int optimixedPower(int a, int n) {
        if (n == 0)
            return 1;

        int halfPower = optimixedPower(a, n / 2);
        if (n % 2 != 0)
            return a * halfPower * halfPower;

        return halfPower * halfPower;

    }

    public int tillingProblem(int n) {
        if (n == 0 || n == 1)
            return 1;

        //vertical choice
        int fnm1 = tillingProblem(n - 1);
        //horizontal choice
        int fnm2 = tillingProblem(n - 2);
        int totalWays = fnm1 + fnm2;

        return totalWays;

    }

    public static void removeDuplicates(String str, StringBuilder sb, int idx, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(sb);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == false) {
            sb.append(currChar);
            map[currChar - 'a'] = true;
        }
        removeDuplicates(str, sb, idx + 1, map);

    }

    public static int friendsPairingWays(int n) {
        if (n == 1 || n == 2)
            return n;

        return friendsPairingWays(n - 1) + (n - 1) * friendsPairingWays(n - 2);
    }

    public static void printBinNumbers(int n, int lastPlace, String str){
        if(n == 0)
        {
            System.out.println(str);
            return;
        }
        printBinNumbers(n-1,0,str+0);

            printBinNumbers(n-1,1,str+1);

    }

    public static void printBinNumbers2(int n, int lastPlace, String str){
        if(n == 0)
        {
            System.out.println(str);
            return;
        }
        printBinNumbers2(n-1,0,str+0);
        if(lastPlace == 0) {
            printBinNumbers2(n - 1, 1, str + 1);
        }

    }
}