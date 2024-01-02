package org.example.Queue;

public class QueueUsingLL {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

     static class Queue{
        Node head = null;
        Node tail = null;

        public  boolean isEmpty(){
            return head == null && tail == null;
        }

        public  void add(int data){
            Node newNode  = new Node(data);

            if(isEmpty()){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public  int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            if(tail == head){
                tail = head = null;
            }
            else {
                head = head.next;
            }

            return front;
        }

        public  int peek(){
            if(isEmpty()){
                System.out.println("Empty queue");
            return -1;
            }
            return head.data;
        }

    }

    public static void main(String[] args) {
        Queue myqueue = new Queue();
        myqueue.add(1);
        myqueue.add(2);
        myqueue.add(3);

        while (!myqueue.isEmpty()){
            System.out.println(myqueue.peek());
            myqueue.remove();
        }

    }

}
