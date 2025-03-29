package org.example.BinaryTree;

/*
    Problem:
    Find total number of paths in Binary Tree jya path varun node-to-node sum = targetSum asto.
    Paths must go downward (parent to child) but can start and end at any node.
    ✅ Logic:
    pathSum() method:
    Tree traverse karto recursively, pratyek node pasun path start karun findPathSum() call karto.
    Har ek node consider karto as a starting point for a path.
    findPathSum() method:
    Current path cha sum maintain karto.
    Jar sum targetSum barobar jala, tar total++ karto.
    Mag left ani right subtree la recursively check karto with updated sum.
    total variable globally maintain kelay to count number of valid paths.
    ✅ Complexity:
    Time: Worst-case O(n²) (for each node, traverse all paths below it).
    Space: O(h) (recursion stack, h = height of tree).
    ✅ Output:
    Main method madhe pathSum(root, targetSum) call karto and total valid paths print karto.
    This approach checks all possible downward paths from every node.
 */
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
