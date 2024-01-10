package org.example.BinarySearchTree;

public class SortedArrayToBalancedBST {
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

        //time complexity is O(n)
        public static Node insertBalancedHeightNodes(int arr[], int start, int end){

            if(start>end)
            {
                return null;
            }

            int mid  = (start+end)/2 ;
           Node root = new Node(arr[mid]);
           root.left = insertBalancedHeightNodes(arr,start,mid-1);
           root.right = insertBalancedHeightNodes(arr,mid+1,end);

           return root;
        }

        public static void preOrder(Node root) {

            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }


        public static void main(String[] args) {
            int array[] = {3,5,6,8,10,11,12};

            System.out.println();

            Node root = insertBalancedHeightNodes(array,0,array.length-1);
            preOrder(root);

        }
    }
}
