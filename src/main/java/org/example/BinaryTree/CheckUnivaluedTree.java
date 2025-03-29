package org.example.BinaryTree;
/*
    Problem:
    Ek binary tree madhle sagle nodes same value che (univalued) aahet ki nahi te check karaycha aahe.
    Logic:
    Recursive method (checkifUnivalued) vaprun each node cha data, tyachya left ani right child sobat compare karto.
    Jar kahi node cha data tya child node peksha vegla asel tar direct false return karto.
    Saglya nodes sathi jar ha condition valid asel tar true return karto.
    Complexity:
    Time: O(n) (each node exactly once)
    Space: O(h) (recursion stack height-wise)
    Final madhye "true" or "false" result verify karto.
 */
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

