package org.example.BinarySearchTree;

public class PrintInRange {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static Node insertNode(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (root.data > data) {
                root.left = insertNode(root.left, data);
            } else {
                root.right = insertNode(root.right, data);
            }

            return root;
        }

        public static void inOrder(Node root) {

            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        public static void printInRange(Node root, int k1, int k2){
            if(root == null)
            {
                return;
            }

            if(root.data>=k1 && root.data<=k2){
                printInRange(root.left,k1,k2);
                System.out.print(root.data+" ");
                printInRange(root.right,k1,k2);
            } else if (root.data<k1) {
                printInRange(root.left,k1,k2);
            }
            else {
                printInRange(root.right,k1,k2);
            }
        }
        public static void main(String[] args) {
            Node root = null;
            int array[] = {8,5,3,1,4,6,10,11,14};
            for (int i = 0; i < array.length; i++) {
                root = insertNode(root, array[i]);
            }
            inOrder(root);
            System.out.println();
            System.out.println("The nodes in the given range are ");
            printInRange(root,5,12);
        }
    }
}
