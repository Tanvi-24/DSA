package org.example;

public class Patterns {
    public static void main(String[] args) {

        printSquarePattern(4);
        System.out.println();
        printStar(4);
        System.out.println();
        printHalfPyramid(4);
        System.out.println();
        printFullPyramid(4);
        System.out.println();
        printUpwardsDownPyramid(5);
        System.out.println();
        printChar(5);


    }

    public static void printChar(int num){
        char t = 'A';
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(t);
                t++;  // Increment the character after printing the row
            }
            System.out.println();
        }
    }


    public static void printInvertedHalfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printUpwardsDownPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printFullPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printHalfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }

       /* for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }*/
    }
    public static void printStar(int n){
        for(int i=1;i<=n;i++){
            for(char j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printAlphaM1(int n){
        for(int i=1;i<=n;i++){
            int a=0;
            for(char j=97;j<=i+96;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void printAlpha(int n){
        for(int i=1;i<=n;i++){
            for(char j=97;j<=i+96;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void printSquarePattern (int n){
        for(int i=1;i<=n;i++){
            for(int k=1;k<=n;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }




}
