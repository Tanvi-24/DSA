package org.example.BinaryTree;
/*
    Problem:
    Ek given Binary Tree (BT) la Doubly Linked List (DLL) madhe convert karaycha aahe (inorder sequence madhe).
    Logic:
    Recursive method (convertBTToDLL) inorder traversal ni binary tree convert karto.
    Left subtree convert kelela DLL cha last node (tail) current root node shi connect karto (left/right pointers vaprun).
    Right subtree same logic vaprun convert karto ani last la tail update karto.
    Implementation Detail:
    tail global variable maintain kelay jo last node store karto, jyamule efficient ani simple linking hoil.
    Recursion madhe head node return hoto jo converted DLL cha starting point asto.
    Complexity:
    Time: O(n) (each node exactly once visit hoto)
    Space: O(h) (recursion stack, h = height of tree)
    Final madhye DLL traversal karun inorder sequence verify karto.
 */
public class BTToDLL {
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static Node tail=null;
    public static Node convertBTToDLL(Node root){
        if(root == null){
            return root;
        }

        Node head = convertBTToDLL(root.left);
        if(tail == null){
            head=root;
            tail=head;
        }
        else  //appends element to the right and tail is set to the last element appended
        {
            tail.right=root;
            root.left=tail;
            tail=root;
        }

        convertBTToDLL(root.right);
        return head;
    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
    public static void traversal(Node root){
        while (root!=null){
            System.out.print(root.data+" ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right =new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left =  new Node(6);
    root.right.right = new Node(7);
    System.out.println("Inorder traversal before converting to DLL");
    inorderTraversal(root);
    Node head = convertBTToDLL(root);
    System.out.println("\nInorder traversal after converting to DLL");
    traversal(head);

        }
}
