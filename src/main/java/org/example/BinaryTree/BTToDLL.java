package org.example.BinaryTree;

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
