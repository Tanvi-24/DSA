package org.example.BinaryTree;
/*
    Problem:
    Given Binary Tree la Sum Tree madhe convert karaycha aahe — mhanje pratyek node cha value tyachya left + right subtree cha total sum asava.
    ✅ Logic:
    calculateSum() method:
    Recursively left and right subtree cha sum calculate karto.
    Current node chya original data la temporarily store karto (return karnyasathi).
    Left subtree + right subtree cha total sum gheun current node cha data update karto.
    Last la original node data return karto for parent calculation.
    Note:
    Leaf nodes la 0 banaval jate (karan left/right null astat).
    preOrder() method:
    Final tree preorder format madhe print karto to verify transformation.
    ✅ Complexity:
    Time: O(n) — each node visit once
    Space: O(h) — recursion stack (h = tree height)
    ✅ Output:
    calculateSum() call karun tree transform karto, and preOrder() ni updated tree print karto.
    Original node values lost hote and replaced by sum of left and right subtree nodes.
 */
public class TransformTOSumTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static int calculateSum(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = calculateSum(root.left);
            int rightSum = calculateSum(root.right);
            int data = root.data;
            int totalSum = leftSum+rightSum;

            if(root.left!=null){
                totalSum = totalSum+root.left.data;
            }
            if(root.right!=null){
                totalSum = totalSum+root.right.data;
            }
            root.data = totalSum;

            return data;
        }


        public static void preOrder(Node root){
            if(root == null)
            {
                return;
            }

            System.out.print(root.data+ " ");
            preOrder(root.left);
            preOrder(root.right);

        }
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right =new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left =  new Node(6);
            root.right.right = new Node(7);

            int data  = calculateSum(root);
            System.out.println(data);
            preOrder(root);


        }

    }
}
