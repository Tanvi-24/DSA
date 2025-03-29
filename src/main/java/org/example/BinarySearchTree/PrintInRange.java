package org.example.BinarySearchTree;
/*
    Problem: Given Binary Search Tree (BST) madhye specific range (k1 to k2) madhle nodes print karayche aahet.
    Logic: Method printInRange() recursive approach ni BST madhye specific range madhle nodes efficiently search karte:
    Current node data jar range madhye asel (k1 <= root.data <= k2), tar left ani right subtree check karto.
    Current node data jar range peksha kami asel (root.data < k1), tar right subtree madhye search karto.
    Current node data jar range peksha jasta asel (root.data > k2), tar left subtree madhye search karto.
    Advantage:
    BST cha property use karun unnecessary nodes skip karto, jyane traversal efficient hote.
    Complexity:
    Time: O(h + m) (h = height, m = number of nodes in range)
    Space: O(h) (recursion stack height wise).
 */
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
