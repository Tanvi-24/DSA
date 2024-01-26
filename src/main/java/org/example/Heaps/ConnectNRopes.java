package org.example.Heaps;

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int arr[] = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int sum = 0;
        int cost=0;
        while (pq.size() != 1){
            int n1 = pq.remove();
            int n2 = pq.remove();
            sum = n1+n2;
            cost += sum;
            pq.add(sum);
        }

        System.out.println("Minimum cost to connect all ropes is "+cost);
    }
}
