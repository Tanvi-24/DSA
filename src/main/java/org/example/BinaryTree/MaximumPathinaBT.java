package org.example.BinaryTree;

public class MaximumPathinaBT {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        //todo
        public static int findMaxPathSum(Node root){
            return 0;
        }

        public static void main(String[] args) {
            Node root = new Node(-10);
            root.left= new Node(9);
            root.right = new Node(20);
            root.right.left = new Node(15);
            root.right.right = new Node(7);
        }
    }
}
