package org.example.BinaryTree;
/*
    Problem:
    Binary Tree madhye don nodes madhil minimum distance (in terms of number of edges) find karaycha aahe.
    ✅ Logic Breakdown:
    Step 1: Find LCA (Lowest Common Ancestor)
    lca2() method recursively common ancestor find karto for nodes n1 and n2.
    Jar current node n1/n2 sarkha asel, tar to LCA asto.
    Donhi subtrees madhun recursive check karto.
    Step 2: Find Distance from LCA to Each Node
    lcaDist() method LCA pasun node n1/n2 paryant cha distance calculate karto.
    If current node null asel, return -1.
    If match jala tar return 0.
    Nantar left/right distance madhun valid distance return karto with +1.
    Step 3: Final Distance
    minDist() method madhe:
    First LCA find karto
    Then LCA to n1 and LCA to n2 cha distance calculate karto
    Final result = dist1 + dist2
    ✅ Complexity:
    Time: O(n) – Full tree traverse karto
    Space: O(h) – Recursion stack (h = height of tree)
    ✅ Output:
    Main method madhe minDist(root, 4, 5) call karun minimum distance print karto.
    e.g., Output: Minimum distance between two nodes is 2
 */
public class MinDistBetNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

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

        public static int lcaDist(Node root, int n){
             if(root == null){
                 return -1;
             }

             if(root.data == n){
                 return 0;
             }

             int leftDist = lcaDist(root.left,n);
             int rightDist = lcaDist(root.right,n);

             if(leftDist == -1 && rightDist == -1){
                 return -1;
             }
             else if(leftDist == -1){
                 return rightDist+1;
             }
             else {
                 return  leftDist+1;
             }
        }
        public static int minDist(Node root, int n1, int n2){
            Node lca = lca2(root,n1,n2);
            int dist1 = lcaDist(lca,n1);
            int dist2 = lcaDist(lca,n2);

            return dist1+dist2;
        }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right =new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left =  new Node(6);
            root.right.right = new Node(7);
            System.out.println("Minimum distance between two nodes is "+minDist(root,4,5));
        }
    }
}
