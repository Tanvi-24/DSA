package org.example.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//time complexity is O(n) for all
public class CreateBT {
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1)
            {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root){

            if(root == null){
//                System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public  void inOrder(Node root){
            if(root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root){
            if(root == null){
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        //using queue data structure to print level order traversal
        public void bfs(Node root){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Node temp = q.remove();
                if(temp == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    System.out.print(temp.data + " ");
                    if(temp.left!= null)
                        q.add(temp.left);
                    if(temp.right != null)
                        q.add(temp.right);
                }
            }
        }

        public int height(Node root){
            if (root == null){
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }

        public int countNodes(Node root){
            if (root == null){
                return 0;
            }
            return countNodes(root.left)+countNodes(root.right)+1;
        }

        public int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum+rightSum+root.data;
        }

        //time complexity is O(n^2)
        public int diameterOfTree(Node root) {
            if(root == null){
                return 0;
            }

            int leftd = diameterOfTree(root.left);
            int rightd = diameterOfTree(root.right);

            int leftheight = height(root.left);
            int rightheight = height(root.right);
            int selfd = leftheight+rightheight+1;

            return Math.max(selfd,Math.max(leftd,rightd));

        }

        static class Info{
            int diameter;
            int ht;

            public Info(int diameter, int ht){
                this.diameter =diameter;
                this.ht = ht;
            }
        }

        //Time complexity is O(n)
         public Info findDiameter(Node root){
            if(root == null){
                return new Info(0,0);
            }

            Info leftInfo = findDiameter(root.left);
            Info rightInfo = findDiameter(root.right);

            int diameter = Math.max(leftInfo.ht+rightInfo.ht+1,Math.max(leftInfo.diameter,rightInfo.diameter));
            int height  = Math.max(leftInfo.ht, rightInfo.ht)+1;

            return new Info(diameter,height);
        }

    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes);
        System.out.println("root is "+root.data);

        System.out.println("Preorder traversal is ");
        binaryTree.preOrder(root);

        System.out.println("\nInorder traversal is ");
        binaryTree.inOrder(root);

        System.out.println("\nPostorder traversal is ");
        binaryTree.postOrder(root);

        System.out.println("\nLevel order traversal is ");
        binaryTree.bfs(root);

        System.out.println("Height of the tree is "+ binaryTree.height(root));
        System.out.println("Count of Nodes in the tree is "+ binaryTree.countNodes(root));
        System.out.println("Sum of all the nodes of the tree is "+binaryTree.sumOfNodes(root));
        System.out.println("Diameter of tree "+ binaryTree.diameterOfTree(root));
        BinaryTree.Info info = binaryTree.findDiameter(root);
        System.out.println("Diameter of tree with reduced time complexity "+ info.diameter);
    }

}
