package org.example.Heaps;

import java.util.ArrayList;

public class CreateMinHeap {

    static class MinHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1) / 2;
            while (arr.get(x) < arr.get(par)) { //O(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public int delete(){
            int val = arr.get(0);
            //step 1 swap with leaf node
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2
            arr.remove(arr.size()-1);
            //step 3 fix heap
            heapify(0);
            return val;
        }


        private void heapify(int index){
            int left = 2*index+1;
            int right = 2*index+2;
            int minIdx = index;

            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx =  left;
            }

            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx =  right;
            }

            if(minIdx != index){
                //swap
                int temp =  arr.get(index);
                arr.set(index,arr.get(minIdx));
                arr.set(minIdx,temp);
                heapify(minIdx);
            }
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(5);
        heap.add(3);
        heap.add(4);
        heap.add(2);
        heap.add(10);
        heap.add(6);

        for(int i=0;i<heap.arr.size();i++){
            System.out.print(heap.arr.get(i)+ " ");
        }

        System.out.println("\nminimum value in a min heap is "+heap.peek());
        System.out.println(heap.delete());
        System.out.println("minimum value in a min heap after deleting is "+heap.peek());

        /*for(int i=0;i<heap.arr.size();i++){
            System.out.print(heap.arr.get(i)+ " ");
        }*/
        System.out.println();
        while(!heap.isEmpty()){
            System.out.println(heap.peek());
            heap.delete();
        }
    }

}