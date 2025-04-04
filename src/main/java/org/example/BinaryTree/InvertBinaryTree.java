package org.example.BinaryTree;
/*
    Problem:
    Ek given Binary Tree la invert (swap) karaycha aahe; left subtree ani right subtree cha position interchange karaychi aahe.
    Logic:
    Recursive method (invertTree) vaprun post-order traversal madhye (left-right-root) invert kartoy:
    First, left ani right subtrees separately invert karto.
    Nantar current root cha left ani right child swap karto.
    Implementation detail:
    Temporary Node (temp) vaprun swapping easy kelay.
    Complexity:
    Time: O(n) (each node exactly once visit karto)
    Space: O(h) (recursion stack mule)
    Final madhye tree cha preorder traversal print karun inverted tree verify karto.
 */
public class InvertBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static void invertTree(Node root){

            if(root == null){
                return;
            }
            invertTree(root.left);
            invertTree(root.right);

            Node temp = root.left;
            root.left= root.right;
            root.right= temp;

            //invert without using a temp Node
            /*
            //base case
            if(root == null){
                return root;
            }
            Node left = invertTree(root.left);
            Node right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;
            */

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
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            invertTree(root);
            preOrder(root);
        }
    }
}
