package org.example.StringProblems;

public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int diff=0;
        int[] num1;
        int[] num2;
        if(array1.length>array2.length){
            diff = array1.length-array2.length;
            num2 = new int[array2.length+diff];
            num1 = new int[array1.length];
        }
        else{
            diff = array2.length-array1.length;
            num1 = new int[array1.length+diff];
            num2 = new int[array2.length];
        }

        for(int i=0;i<array1.length;i++){
            int num = Integer.parseInt(array1[i]);
            num1[i] = num;
        }

        for(int i=0;i<array2.length;i++){
            int num = Integer.parseInt(array2[i]);
            num2[i] = num;
        }

        int compare = -1;
        for(int i=0;i<num1.length;i++){
            if(num2[i]==num1[i]){
                compare =0;
            }
            else if(num2[i]>num1[i]){
                compare = -1;
                return compare;
            }
            else{
                compare = 1;
                return compare;
            }
        }

        return compare;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1","1"));
    }
}
