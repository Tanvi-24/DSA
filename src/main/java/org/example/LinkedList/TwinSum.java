package org.example.LinkedList;

class NodeS{
    int data;
    NodeS next;

    NodeS(int data){
        this.data = data;
        this.next = null;
    }
}
public class TwinSum {
    public static NodeS head;
    public static NodeS tail;

    public int pairSum(NodeS head) {
        NodeS fast = head, slow = head;
        int max = Integer.MIN_VALUE;
        int count;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;
        }
        NodeS curr = slow, prev = null, next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while(prev!=null){
            count = head.data+prev.data;
            max = Math.max(count,max);
            head = head.next;
            prev = prev.next;
        }

        return max;
    }

    public static void addFirst(int data){
        NodeS n = new NodeS(data);
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
        NodeS n = new NodeS(data);
        if(head == null){
            head = n;
        }
        else {
            NodeS temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
            tail = n;
        }
    }

    public void printLL(NodeS head){
        NodeS temp = head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        TwinSum ll = new TwinSum();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.printLL(head);
        System.out.println("\n"+ll.pairSum(head));
        System.out.println();
        ll.printLL(head);


    }
}
