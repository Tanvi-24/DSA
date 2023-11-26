package org.example;

public class QuickSort {

    public static void main(String args[]){
        int array[] = {4,3,6,2,1,5};

        quickSort(array,0,array.length-1);
        printArray(array);
    }

    public static void quickSort(int array[],int start, int end){
       if(start>=end)
           return;

       int pivotIdx = partition(array,start,end);
       quickSort(array,start,pivotIdx-1);
       quickSort(array,pivotIdx+1,end);
    }

    public static int partition(int array[],int start,int end){
        int pivot = array[end];
        int i=start-1;

        for (int j=start;j<end;j++){
            if(array[j]<=pivot){
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        array[end] = array[i];
        array[i] = temp;
        return i;

    }
    public static void printArray(int array[]){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}

