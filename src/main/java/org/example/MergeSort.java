package org.example;

public class MergeSort {
    public static void main(String args[]){
        int array[] = {5,3,2,6,4,1,7};
        mergeSort(array,0,array.length-1);
        printArray(array);
    }

    public static void mergeSort(int array[], int start ,int end){
       if(start>=end)
           return;
        int mid = start+((end-start)/2);
        mergeSort(array,start, mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    public static void merge(int array[], int start, int mid, int end){

        int temp[] = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k =  0;
        while (i<=mid && j<=end){
            if(array[i]<array[j]){
                temp[k] = array[i];
                i++;
            }
            else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=array[i++];
        }
        while (j<=end){
            temp[k++]=array[j++];
        }

        for(int num=0,itr=start;num<temp.length;num++,itr++){
            array[itr]=temp[num];
        }
    }

    public static void printArray(int array[]){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
