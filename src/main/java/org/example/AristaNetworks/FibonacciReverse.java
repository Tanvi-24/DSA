package org.example.AristaNetworks;

import java.util.*;
/*
This question is reversing the linked list using fibonacci series count
 1. First create a linked list(here using list of integers in ascending order)
 2. Create a fibonacci series, such that the series does not exceed the largest number,
    (here since 10 is largest, so we need to have fibonacci series only till 8 since after 8 we
    have 13 and 13 is larger than 10 so we break and return the list)
 3. once we have the fibonacci series list, we iterate over the fibonacci list and
    reverse only the number of nodes for example: we have linked list as 1,2,3,4
    and fibonacci series as ,1,1,2,3 accordingly, so the resultant will - 1 2 4 3
    here first number in fibonacci series is 1 so we only reverse 1'st number in the linked list
    after that again in the series we have 1 so will reverse the next number, similary next number
    in the series is 2 so we will reverse two numbers in the linked list i.e 3 and 4
    so the resultant will be 1,2,4,3

 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FibonacciReverse {
    // Generate the Fibonacci sequence up to the length of the linked list
    public static List<Integer> generateFibonacci(int n) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);

        while (fib.get(fib.size() - 1) + fib.get(fib.size() - 2) <= n) {
            fib.add(fib.get(fib.size() - 1) + fib.get(fib.size() - 2));
        }

        return fib;
    }

    // Reverse a portion of the linked list and return new head
    public static Node reverseGroup(Node head, int k) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        // next is now pointing to the (k+1)th node, which becomes the new head for the remaining part
        head.next = curr;

        return prev; // prev is the new head of the reversed group
    }

    // Main function to reverse the linked list in Fibonacci group sizes
    public static Node reverseInFibonacciGroups(Node head) {
        if (head == null || head.next == null) return head;

        // Find the length of the linked list
        int length = getLength(head);

        // Generate Fibonacci sequence up to the length of the linked list
        List<Integer> fibonacciSeq = generateFibonacci(length);

        Node current = head;
        Node newHead = null;
        Node prevTail = null;
        int i = 0;

        while (current != null && i < fibonacciSeq.size()) {
            int k = fibonacciSeq.get(i); // Get the current Fibonacci group size

            if (k > length) break;

            // Reverse the next k nodes
            Node groupHead = reverseGroup(current, k);

            if (newHead == null) {
                newHead = groupHead;
            } else {
                prevTail.next = groupHead;
            }

            // Move the previous tail to the current head
            prevTail = current;

            // Move current to the next group
            current = current.next;

            i++;
        }

        return newHead;
    }

    // Get the length of the linked list
    public static int getLength(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        System.out.println("Original List:");
        printList(head);

        head = reverseInFibonacciGroups(head);

        System.out.println("Reversed in Fibonacci Groups:");
        printList(head);
    }
}

