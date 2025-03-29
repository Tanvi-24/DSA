package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
    Problem: Given Binary Tree madhe "good nodes" shodhayche aahet.
    "Good node" manje asa node jyacha value root pasun tyachya parent nodes madhlya
    maximum value peksha kami nasel (greater or equal asel).
    Logic:
    Recursive method (findGoodNode) use karun tree traverse karto.
    Root pasun current node paryant cha maximum value track karto.
    Current node cha value tracked maximum peksha kami nasel tar node "good" aahe
    ani tyala list madhe add karto.
    Implementation details:
    Traversal pre-order (root, left, right) cha logic vaprun recursive call karto.
    Finally, "good nodes" cha count (list cha size) print karto.
    Complexity:
    Time: O(n) (each node exactly once)
    Space: O(h) recursion stack + O(n) list space (total good nodes).
    Final madhye good nodes cha count print karun verify karto.
 */
public class FindGoodNodes {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left =null;
            this.right = null;
        }

    }

    static int idx=-1;
    public TreeNode buildTree(int nodes[]){
        idx++;
        if(nodes[idx] == -1)
        {
            return null;
        }

        TreeNode newNode = new TreeNode(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }
    public static void goodNodes(TreeNode root) {
        if(root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();

        findGoodNode(root,root.val,list);
        System.out.println(list.size());

    }

    public static void findGoodNode(TreeNode root,int rootVal,List<Integer> list){
        if(root==null){
            return;
        }

        if(root.val>=rootVal){
            rootVal = root.val;
            list.add(rootVal);
        }


        findGoodNode(root.left,rootVal,list);
        findGoodNode(root.right,rootVal,list);
    }


    public static void main(String arg[]){
        int nodes[] = {3,1,4,3,-1,1,5,-1,-1,-1,-1,-1,-1};
        FindGoodNodes binaryTree = new FindGoodNodes();
      //  TreeNode root = binaryTree.buildTree(nodes);
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-2);
        root.left.left= new TreeNode(4);
        root.left.right=new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(-2);
        root.left.right.left=new TreeNode(-4);
        root.left.right.left.left = new TreeNode(-2);
        root.right.right.left=new TreeNode(-2);
        root.right.right.left.left = new TreeNode(0);
        root.right.right.right = new TreeNode(3);
        root.right.right.right.left = new TreeNode(-1);
        root.right.right.right.right= new TreeNode(-3);
        root.right.right.right.right.left = new TreeNode(-4);
        root.right.right.right.right.right =new TreeNode(-3);
        root.right.right.right.right.right.left = new TreeNode(3);
        root.right.right.right.right.right.left.left = new TreeNode(-3);

        goodNodes(root);
    }
}
