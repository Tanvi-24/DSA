package org.example.LinkedList;

public class ReverseDLL {
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;

    public  void addLast(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }
        else {
            Node temp = head;
            Node p=head;
            while(temp.next!=null){
                temp = temp.next;
                p=temp;
            }
            temp.next = n;
            n.prev = p;
        }
    }

    public void printLL(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public void printReverseUsingPrev(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        while (temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.prev;
        }
        System.out.println("null\n");
    }

    // 1->2->3
    public void reverseDLL(){
        Node current = head;
        Node temp=null;
        //to reverse linked list and point head to the last value we are using condition as current.next!=null or else we could have directly used current!=null
        while(current.next!=null){
            temp =current.next;
            current.next=current.prev;
            current.prev = temp;
            current = current.prev;

            head = current;
        }

        temp =current.next;
        current.next=current.prev;
        current.prev = temp;

    }
    public static void main(String args[]){
        ReverseDLL reverseDLL = new ReverseDLL();
        reverseDLL.addLast(1);
        reverseDLL.addLast(2);
        reverseDLL.addLast(3);
        reverseDLL.printLL(head);
        reverseDLL.reverseDLL();
        reverseDLL.printLL(head);
//        reverseDLL.printReverseUsingPrev(head);


    }
}
