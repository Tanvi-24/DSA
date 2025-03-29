package org.example.BinarySearchTree;
/*
    Problem:
    Ek given Binary Search Tree (BST) cha mirror (exact opposite) tayar karaycha aahe.
    Mirror logic:
    Recursive method mirror() madhye each node cha left subtree ani right subtree swap karto,
    jyane tree cha exact mirror banato.
    Implementation Steps:
    Recursively left ani right subtrees sathi mirror() call karto.
    Recursive call nantar, current node cha left subtree madhe right subtree attach karto,
     ani right subtree madhe left subtree attach karto.
    Result Verification:
    Mirror tree cha inOrder() ani preOrder() traversal print karun verify karto.
    Complexity:
    Time: O(n) (each node exactly once visit hoto)
    Space: O(h) (recursion stack, height of tree).
 */
public class MirrorABST {

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

        public static Node mirror(Node root){
            if(root == null){
                return null;
            }

            Node left = mirror(root.left);
            Node right = mirror(root.right);

            root.left = right;
            root.right = left;
            return root;

        }
        public static void preOrder(Node root){
            if(root == null){
                return;
            }

            System.out.print(root.data+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void main(String[] args) {
            Node root = null;
            int array[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
            for (int i = 0; i < array.length; i++) {
                root = insertNode(root, array[i]);
            }
            inOrder(root);
            System.out.println();
            Node node = mirror(root);
            inOrder(node);
            System.out.println();
            preOrder(node);
        }
    }
}
