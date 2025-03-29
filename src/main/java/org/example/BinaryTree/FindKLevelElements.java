package org.example.BinaryTree;
/*
    Problem:
    Binary Tree madhla ek specific level (k) varche nodes print karayche aahet.
    Logic:
    Recursive method (kLevelNodes) pre-order traversal (root-left-right) vaprun
    each node cha level track karto:
    Root node pasun start karun, current level increment karto.
    Current level k sarkha asel tar node cha data print karto.
    Jar nahi asel, tar recursion ni left ani right subtrees sathi search karto.
    Complexity:
    Time: O(n) (each node exactly once visit karto)
    Space: O(h) (recursion stack mule)
    Final madhye dilelya level (k) che nodes print karto.
 */
public class FindKLevelElements {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        //recursively using preOrder O(n)
        public static void kLevelNodes(Node root,int k, int level){

            if(root == null){
                return;
            }
            if(k == level){
                System.out.print(root.data+" ");
                return;
            }

            kLevelNodes(root.left,k,level+1);
            kLevelNodes(root.right,k,level+1);
        }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right =new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left =  new Node(6);
            root.right.right = new Node(7);
            kLevelNodes(root,2,1);
        }

    }


}
