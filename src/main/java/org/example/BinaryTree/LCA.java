package org.example.BinaryTree;

import java.util.ArrayList;
/*
    Problem:
    Binary Tree madhye dilelya don nodes saathi Lowest Common Ancestor (LCA) shodhaycha aahe.
    ✅ Method 1: Using Path Lists (lca)
    getPath():
    Root pasun target node paryant cha path ArrayList madhe store karto.
    Node match zala ki true return karto; nahi zala tar path madhun node remove karto (backtrack).
    lca():
    Donhi nodes saathi path collect karto.
    Donhi path compare karto, jithe node mismatch hota tya adhi cha last common node return karto (toch LCA asto).
    Time Complexity: O(n)
    Space Complexity: O(n) (path store karnyasathi)

     Method 2: Optimized Recursive Approach (lca2)
    Logic:
    Jar current node null asel, n1/n2 barobar asel tar toh node return karto.
    Left ani right subtree madhun recursive LCA call karto.
    Donhi side var non-null LCA milala tar current node LCA asel.
    Ek side null asel tar dusra LCA return karto.
    Time Complexity: O(n)
    Space Complexity: O(h) (recursion stack, h = height of tree)
    ✅ Output:
    Main method madhye lca() ani lca2() donhi methods call karun LCA print karto.
    Donhi methods correct aahet, pan lca2() optimized aahe (less space usage).
 */
public class LCA {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static boolean getPath(Node root,int n, ArrayList<Node> path){
            if(root == null)
                return false;

            path.add(root);
             if(root.data == n){
                 return true;
             }

             boolean leftFound = getPath(root.left,n,path);
             boolean rightFound = getPath(root.right,n,path);

             if(leftFound || rightFound){
                 return true;
             }

             path.remove(path.size()-1);
             return false;
        }

        //time complexity - O(n)
        //space complexity - O(n)
        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root,n1, path1);
            getPath(root,n2,path2);

            int i=0;
            for (;i<path1.size() && i<path2.size();i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            Node lca = path1.get(i-1);
            return lca;
        }

        //space complexity is constant time complexity O(n)
        public static Node lca2(Node root, int n1, int n2){

            if(root == null || n1 == root.data || n2 == root.data){
                return root;
            }

            Node leftLca = lca2(root.left,n1,n2);
            Node rightLca = lca2(root.right,n1,n2);
            //leftLca is valid and right is null i.e the lca exist only in left subtree
            if(rightLca == null){
                return leftLca;
            }
           //rightLca is valid and left is null i.e the lca exist only in right subtree
            if(leftLca == null){
                return rightLca;
            }

            return root;

        }
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right =new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left =  new Node(6);
            root.right.right = new Node(7);
            System.out.println("Lowest common ancestor of the given elements is "+lca(root,4,6).data);
            System.out.println("Lowest common ancestor of the given elements is "+lca2(root,4,5).data);

        }
    }
}
