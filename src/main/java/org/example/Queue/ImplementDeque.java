package org.example.Queue;

import java.util.ArrayList;
import java.util.List;

public class ImplementDeque {
    static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static class Dequeue{
        Node head = null;
        Node tail = null;

        public void addFront(int num){
            Node node = new Node(num);
            if(head == null){

                head = tail = node;
            }
            else{
                head.prev = node;
                node.next=head;
                head = node;
            }
        }

        public void addRear(int num){
            Node node = new Node(num);
            if(tail == null){
                tail=head=node;
            }
            else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public Node removeFront(){
            Node node = head;
            head = head.next;
            if(head == null){
                tail = null;
            }else {
                head.prev = null;
            }
            return node;
        }

        public Node removeRear() {
            Node node = tail;
            tail = tail.prev;
            if(tail == null){
                head = null;
            }else {
                tail.next = null;
            }
            return node;
        }

        public Node peekFront(){
            return head;
        }

        public Node peekRear(){
            return tail;
        }

        public boolean isEmpty(){
            if(head == null){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
     Dequeue dequeue = new Dequeue();
     dequeue.addFront(1);
     dequeue.addRear(2);
     while (!dequeue.isEmpty()){
         Node node = dequeue.removeFront();
         System.out.println(node.data);
     }
    }
}
