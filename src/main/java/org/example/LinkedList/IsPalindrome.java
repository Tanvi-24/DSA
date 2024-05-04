package org.example.LinkedList;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class IsPalindrome {
    public static Node head;
    public static Node tail;

    public static void addFirst(int data){
        Node n = new Node(data);
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
        Node n = new Node(data);
        if(head == null){
            head = n;
        }
        else {
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
            tail = n;
        }
    }

    public void printLL(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public boolean checkpalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step1 - find mid
        Node midNode = findMiddle(head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        // 1 2 2 1
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node rightHead = prev; //right half head
        Node leftHead = head;

        //step3 - //check left half and second half
        while (rightHead!=null){
            if(leftHead.data!=rightHead.data){
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    public static Node findMiddle(Node head){
        Node slow = head;//+1
        Node fast = head;//+2
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void zigZag(){
       //find mid
        Node slow = head;//+1
        Node fast = head.next;//+2
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //reverse the second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        //alt merge
        while (left!=null && right!=null){
            nextL = left.next;
            left.next =right;
            nextR = right.next;
            right.next = nextL;

            left= nextL;
            right =nextR;
        }

    }
    public static void main(String[] args) {
//        addFirst(1);
//        addFirst(2);
//        addFirst(3);
        IsPalindrome palindrome = new IsPalindrome();
        //palindrome.printLL(head);
        palindrome.addLast(1);
        palindrome.addLast(2);
        palindrome.addLast(3);
        palindrome.addLast(2);
        palindrome.addLast(1);
        System.out.println();
        palindrome.printLL(head);
        System.out.println(" is LL a palindrome : "+palindrome.checkpalindrome());
        IsPalindrome ll = new IsPalindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.zigZag();
        ll.printLL(head);
       // ll.printLL(zz);

    }
}