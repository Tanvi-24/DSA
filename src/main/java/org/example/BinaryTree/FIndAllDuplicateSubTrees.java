package org.example.BinaryTree;

public class FIndAllDuplicateSubTrees {
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
        public static void getAllDuplicates(Node root){}

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(4);
            root.right = new Node(3);
            root.left.left = new Node(3);
            root.right.left = new Node(4);
            root.right.right = new Node(3);
            root.right.left.left = new Node(3);
        }
    }
}
