package org.example.BinarySearchTree;

import java.util.ArrayList;

public class ConvertBTToBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static Node insertBalancedHeightNodes(ArrayList<Integer> list, int start, int end){

            if(start>end)
            {
                return null;
            }

            int mid  = (start+end)/2 ;
            Node root = new Node(list.get(mid));
            root.left = insertBalancedHeightNodes(list,start,mid-1);
            root.right = insertBalancedHeightNodes(list,mid+1,end);

            return root;
        }

        public static void preOrder(Node root) {

            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inOrder(Node root, ArrayList<Integer> list){
            if(root == null){
                return;
            }
            inOrder(root.left,list);
            list.add(root.data);
            inOrder(root.right,list);
        }

        public static void main(String[] args) {
            Node root = new Node(8);
            root.left = new Node(6);
            root.right = new Node(10);
            root.left.left = new Node(5);
            root.left.left.left = new Node(3);
            root.right.right = new Node(11);
            root.right.right.right = new Node(12);

            System.out.println();
            ArrayList<Integer> list = new ArrayList<>();
            inOrder(root,list);
            root = insertBalancedHeightNodes(list,0,list.size()-1);
            preOrder(root);
        }
    }
}
