package org.example.AristaNetworks;

import java.util.LinkedList;
import java.util.List;

/* Given a sorted doubly link list and two numbers C and K.
You need to decrease the info of node with data K by C and insert the new node formed at its correct position,
such that the list remains sorted.*/
public class DLL {

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    public static Node head = null;
    public static Node tail = null;

    public static void insertAtBeginning(int data)
    {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public static void insertAtEnd(int data)
    {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }
    public static void deleteAtBeginning()
    {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    public static void deleteAtEnd()
    {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    public static void reduceCByK(int C, int K){
        Node temp = head;
        while(temp != null && temp.data != C){
            temp = temp.next;
        }

        if(temp.data == C){
            if(K<C){
                Node newNode = new Node(temp.data-K);

                if((temp.next!=null && newNode.data<=temp.next.data) && (temp.prev!=null && newNode.data>=temp.prev.data)){
                   temp.data =newNode.data;
                    return;
                }
                Node currElement = temp.prev;
                Node nextElement = temp.next;
                currElement.next =  nextElement;
                nextElement.prev = currElement;
                temp.next = null;
                temp.prev = null;

                if(currElement!=null && newNode.data>currElement.data){
                    Node prevNode = currElement;
                    while (prevNode.data < newNode.data){
                        prevNode = prevNode.next;
                    }

                    newNode.next = prevNode;
                    newNode.prev = prevNode.prev;
                    prevNode.prev.next = newNode;
                    prevNode.prev = newNode;
                }
                else if(currElement!=null && newNode.data<currElement.data){
                    Node prevNode = currElement;
                    while(prevNode.data>newNode.data){
                        prevNode = prevNode.prev;
                    }
                    newNode.prev = prevNode;
                    newNode.next = prevNode.next;
                    prevNode.next.prev = newNode;
                    prevNode.next = newNode;
                }
            }

        }
    }

    public static void main(String[] args) {
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);
        insertAtEnd(6);

//        Node temp = head;
//        while(temp!=null){
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//        Node last = tail;
//        while (last != null) {
//            System.out.println(last.data);
//            last= last.prev;
//        }

        int C = 4,K=2;
        reduceCByK(C,K);
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }

        List<Integer> dll = new LinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.add(6);

        System.out.println(dll);
        if(dll.contains(C)){
            int currIndex = dll.indexOf(C);
            int num = C-K;
            if((currIndex>0 && dll.get(currIndex-1)<=num) && (currIndex<dll.size()-1 && dll.get(currIndex+1)>=num)){
                dll.add(currIndex,num);
            }
            else{
                dll.remove(Integer.valueOf(C));
                for(int i=0;i<dll.size();i++){
                    if(num<=dll.get(i)){
                        dll.add(i,num);
                        break;
                    }
                }
            }
        }
        System.out.println(dll);
    }
}
