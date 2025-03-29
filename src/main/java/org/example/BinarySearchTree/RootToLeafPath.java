package org.example.BinarySearchTree;

import java.util.ArrayList;
/*
    Problem: Binary Search Tree (BST) madhye root node pasun leaf node paryanta sagle
    possible paths print karayche aahet.
    Logic: Recursive method printRootToLeafPath():
    Current node list madhye add karto.
    Leaf node (left ani right null) asel tar list madhla path print karto.
    Recursive call left ani right subtree sathi karto, ani backtrack karnyasathi list madhla
     last node remove karto.
    Backtracking cha use:
    Backtracking mule ekach list madhye sagle paths efficiently store ani print karto.
    Complexity:
    Time: O(n) (each node once)
    Space: O(h) recursion stack + O(h) list space, (h = tree height).
 */
public class RootToLeafPath {
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

        public static ArrayList<Node> list = new ArrayList<>();
        public static void printRootToLeafPath(Node root){

            if(root == null){
                return;
            }
            list.add(root);
           if(root.left == null && root.right == null){
               for(int i=0;i<list.size();i++){
                   System.out.print(list.get(i).data+ "-");
               }
               System.out.print("null");
               System.out.println();
           }
            printRootToLeafPath(root.left);
            printRootToLeafPath(root.right);
            list.remove(list.size()-1);

        }

        public static void main(String[] args) {
            Node root = null;
            int array[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
            for (int i = 0; i < array.length; i++) {
                root = insertNode(root, array[i]);
            }
            inOrder(root);
            System.out.println();
            printRootToLeafPath(root);
        }
    }
}
