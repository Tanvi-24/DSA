package org.example.BinaryTree;

import java.util.ArrayList;

public class TargetSumPathCount {

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

    int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        findPathSum(root, targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);

        return total;

    }

    public void findPathSum(TreeNode root, int targetSum, long sum){
        if(root == null){
            return;
        }

        sum =sum+root.val;
        if(sum == targetSum)
        {
            total++;
        }

        findPathSum(root.left,targetSum,sum);
        findPathSum(root.right,targetSum,sum);
    }

    public static void main(String[] args) {
        //[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);

        TargetSumPathCount tp = new TargetSumPathCount();
        System.out.println(tp.pathSum(root,0));

    }

}
