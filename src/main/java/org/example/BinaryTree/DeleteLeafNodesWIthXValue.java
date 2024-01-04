package org.example.BinaryTree;

public class DeleteLeafNodesWIthXValue {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static int deleteLeafNode(Node root,int data){
           //in this we can replace the return type to Node and return null and root based on the condition
           //i.e replace 0 with root and 1 with null
            if(root == null){
                return 0;
            }

            if(root.left == null && root.right == null && root.data == data){
                return 1;
            }

            if(deleteLeafNode(root.left,data) == 1){
                root.left = null;
            }

            if(deleteLeafNode(root.right,data) == 1){
                root.right = null;
            }
            return 0;
        }

        public static void preOrder(Node root){
            if(root == null){
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(3);
            root.right = new Node(3);
            root.left.left = new Node(3);
            root.left.right = new Node(2);
            deleteLeafNode(root,3);
            preOrder(root);
        }
    }
}
