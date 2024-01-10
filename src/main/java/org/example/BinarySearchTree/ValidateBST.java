package org.example.BinarySearchTree;

public class ValidateBST {
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

        //find max inorder predecessor in left subtree and min successor in right subtree and compare it to root
        public static boolean validateBST(Node root, Node min, Node max){
            if(root == null){
                return true;
            }

            if(min != null && root.data <= min.data){
                return false;
            }

            if(max != null &&root.data >= max.data){
                return false;
            }

            return validateBST(root.left,min,root) && validateBST(root.right,root,max);

        }

        public static void main(String[] args) {
            Node root = null;
            int array[] = {1,1,1};
            for (int i = 0; i < array.length; i++) {
                root = insertNode(root, array[i]);
            }
            inOrder(root);
            System.out.println();
            System.out.println("Is tree a valid bst "+validateBST(root,null,null));
        }
    }
}
