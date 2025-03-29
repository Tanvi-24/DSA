package org.example.DESHAW;

// Java program to detect and remove loop in linked list
/*
    Detect kara ki linked list madhe cycle/loop ahe ka, aani jari asel tar toh remove kara.
    ✅ Step 1: Detect Loop (Floyd’s Algorithm):
    slow = 1 step
    fast = 2 steps
    Jar kahi point var slow == fast zale, tar loop ahe.
    ✅ Step 2: Remove Loop:
    Loop madhe traversal karun loop length count karto.
    Last node je loop madhe next point karto — tyacha .next = null karun cycle break karto.

 */
class RemoveCycleLL {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int x)
        {
            data = x;
            next = null;
        }
    }

    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node)
    {
        Node slow = node, fast = node;
        while (slow != null && fast != null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop
            // is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    void removeLoop(Node loop, Node head)
    {
        Node ptr1 = loop;
        Node ptr2 = loop;

        // Count the number of nodes in loop
        int k = 1, i;
        Node prevNode = ptr1;
        while (ptr1.next != ptr2) {
            // keeping track before moving next
            prevNode = ptr1;
            ptr1 = ptr1.next;
            k++;
        }
        prevNode.next = null;
    }

    // Function to print the linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        RemoveCycleLL list = new RemoveCycleLL();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println(
                "Linked List after removing loop : ");
        list.printList(head);
    }
}
