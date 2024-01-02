package org.example.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueue {

    public static void interleaveQueue(Queue<Integer> q1){
        Queue<Integer> q2 = new LinkedList<>();
        int size = q1.size()/2;
        System.out.println(size);
        for (int i=0;i<size;i++){
            q2.add(q1.remove());
        }

        while (!q2.isEmpty()){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
        while (!q1.isEmpty()){
            System.out.print(q1.remove()+" ");
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        for (int i=1;i<=6;i++){
            q1.add(i);
        }
        interleaveQueue(q1);
    }
}
