package org.example.LinkedList;

class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class OddEvenLinkedList {
    public static ListNode head;
    public static ListNode tail;

    public static void addFirst(int data){
        ListNode n = new ListNode(data);
        if(head == null){
            head = n;
            tail = n;
        }
        else {
            n.next = head;
            head = n;
        }
    }

    public  void addLast(int data){
        ListNode n = new ListNode(data);
        if(head == null){
            head = n;
        }
        else {
            ListNode temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
            tail = n;
        }
    }
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode odd=head, even= head.next;
        ListNode evenList = even;
        while(odd != null && even != null && even.next!=null){
            odd.next = even.next;
            odd= odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenList;
        return head;

    }


    public void printLL(ListNode head){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }


    public static void main(String[] args) {
        OddEvenLinkedList ll = new OddEvenLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.printLL(head);
        ll.oddEvenList(head);
        System.out.println();
        ll.printLL(head);


    }
}

