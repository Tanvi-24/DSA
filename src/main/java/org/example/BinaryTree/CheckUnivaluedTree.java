package org.example.BinaryTree;

public class CheckUnivaluedTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static boolean checkifUnivalued(Node root){
            if(root == null){
                return true;
            }

            //condition to check left child and parent
            if(root.left!=null && root.data != root.left.data){
                return false;
            }

            //condition to check right child and parent
            if(root.right!=null && root.data != root.right.data){
                return false;
            }
            //condition to check left child and right child
            return checkifUnivalued(root.left) && checkifUnivalued(root.right);
        }
        public static void main(String[] args) {
            Node root = new Node(2);
            root.left = new Node(2);
            root.right = new Node(2);
            root.left.left = new Node(2);
            root.left.right = new Node(2);
            System.out.println("Is BT univalued "+checkifUnivalued(root));
        }
    }


}

