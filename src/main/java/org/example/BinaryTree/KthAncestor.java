package org.example.BinaryTree;

public class KthAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static int findKthAncestor(Node root, int k, int data){
            if(root == null){
                return -1;
            }
            if(root.data == data){
                return 0;
            }

            int leftDist = findKthAncestor(root.left,k,data);
            int rightDist = findKthAncestor(root.right,k,data);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }

            int max = Math.max(leftDist,rightDist);

            if(max+1 == k){
                System.out.println("Kth ancestor is "+ root.data);
            }

            return max+1;
        }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right =new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left =  new Node(6);
            root.right.right = new Node(7);
            int k = 1,data =2;
            System.out.println("Distance of node from root is "+findKthAncestor(root,k,data));
        }
    }
}