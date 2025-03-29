package org.example.BinaryTree;
/*
    Problem:
    Check karaycha aahe ki ek binary tree cha subtree (subRoot) original tree (root) madhye exist karto ka.
    Logic:
    isSubtree() recursively traverse karto original tree madhe.
    Jar current node cha data subRoot cha data barobar asel, tar isIdentical() call karto donhi trees identical aahet ka te check karayla.
    isIdentical() recursively check karto donhi trees cha structure ani node values same aahet ka.
    If identical, return true; nahi tar left ani right subtree madhe search karto.
    Complexity:
    Time: Worst-case O(n*m) jithe n = size of main tree, m = size of subtree.
    Space: O(h) recursion stack (h = height of tree).
    Output:
    Main method madhe isSubtree(root, subRoot) call karto ani result print karto (true/false).
 */
public class SubTreeOfTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null)
        {
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot))
            {
                return true;
            }
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static boolean isIdentical(Node node, Node subRoot)
    {
        if(subRoot== null && node == null)
        {
            return true;
        }
        else if(node == null || subRoot == null || node.data!=subRoot.data){
            return false;
        }
        if(!isIdentical(node.left,subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);


        System.out.println( isSubtree(root,subRoot));
    }
}
