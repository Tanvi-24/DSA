package org.example.BinarySearchTree;

public class BasicBinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static Node insertNode(Node root,int data){
            if(root == null){
                root = new Node(data);
                return root;
            }

            if(root.data > data){
                root.left = insertNode(root.left,data);
            }
            else{
                root.right = insertNode(root.right,data);
            }

            return root;
        }

        //time complexity O(h)
        public static boolean search(Node root,int key){
            if(root == null)
            {
                return false;
            }

            if(root.data == key){
                return true;
            }

            if(key<root.data){
                return search(root.left,key);
            }
            else {
                return search(root.right,key);
            }
        }
        public static void inOrder(Node root){

            if(root == null){
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+ " ");
            inOrder(root.right);
        }

        public static Node searchNode(Node root,int key){
            if(root == null)
            {
                return null;
            }

            if(root.data == key){
                return root;
            }

            if(key<root.data){
                return searchNode(root.left,key);
            }
            else {
                return searchNode(root.right,key);
            }
        }
        public static void main(String[] args) {
            Node root = null;
            int array[] = {4,2,7,1,3};
            for (int i=0;i<array.length;i++){
                root = insertNode(root,array[i]);
            }
            Node node = searchNode(root,2);
            inOrder(node);
            System.out.println();
            inOrder(root);
            System.out.println();
            System.out.println("is key present in tree "+search(root,7));
        }
    }


}
