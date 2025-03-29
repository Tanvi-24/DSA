package org.example.BinarySearchTree;

/*
    Problem: Ek Binary Search Tree (BST) madhun given key delete karaychi aahe.
    Deletion logic (3 cases):
    Leaf node (no child):
    Jar delete karaycha node leaf asel, tar direct tyala remove karun null return karto.
    Ek child asel (either left or right):
    Node delete karun, tyacha ekach child subtree la parent shi attach karto.
    Don children astil:
    Node delete karnyasathi, right subtree madhla Inorder successor (left-most node) shodhun
    current node madhe data copy karto, ani nantar to successor recursively delete karto.
    Implementation:
    Recursive function delete() madhun hi logic apply karun node BST madhun delete karto.
    Complexity:
    Time: O(h) (BST chi height), best-case balanced madhe O(log n), worst-case madhe O(n).
    Space: Recursion stack mule O(h).
 */
public class DeleteNode {
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

        public static void inOrder(Node root){

            if(root == null){
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+ " ");
            inOrder(root.right);
        }

        public static Node delete(Node root, int key){
            if(root == null){
                return null;
            }
            if(root.data<key){
                root.right = delete(root.right,key);
            }
            else if(root.data>key){
                root.left = delete(root.left,key);
            }
            else {
                //found our key
                //case 1 -leaf node
                if(root.left == null && root.right == null)
                {
                    return null;
                }

                //case 2 - if root.left == null
                if(root.left == null){
                    return root.right;
                }
                else if(root.right == null){
                    return root.left;
                }
                else{
                    //both children
                    //left most node in the right subtree
                   Node inorderSuc =  findInorderSuccessor(root.right);
                   root.data = inorderSuc.data;
                   root.right = delete(root.right, inorderSuc.data);
                }
            }
            return root;
        }

        public static Node findInorderSuccessor(Node root){
            while (root.left != null){
                root = root.left;
            }
            return root;
        }
        public static void main(String[] args) {
            Node root = null;
            int array[] = {8,5,3,1,4,6,10,11,14};
            for (int i=0;i<array.length;i++){
                root = insertNode(root,array[i]);
            }

            inOrder(root);
            System.out.println();
            root = delete(root,1);
            inOrder(root);

            System.out.println();
            root = delete(root,10);
            inOrder(root);
        }
    }
}
