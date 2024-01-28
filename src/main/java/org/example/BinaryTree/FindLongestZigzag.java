package org.example.BinaryTree;

public class FindLongestZigzag {

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
    int maxCount = Integer.MIN_VALUE;
    public int longestZigZag(TreeNode root) {


            zigzag(root.left,'r',0);


            zigzag(root.right,'l',0);


        return maxCount;
    }

    public void zigzag(TreeNode root, char dir, int count){

        if(root == null){
            return;
        }

        maxCount  = Math.max(count,maxCount);
        if(dir == 'l'){
            zigzag(root.right,'r',count+1);
            zigzag(root.left,'l',1);
        }
        else{
            zigzag(root.left,'l',count+1);
            zigzag(root.right,'r',1);

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left =new TreeNode(1);;
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right =new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        FindLongestZigzag findLongestZigzag = new FindLongestZigzag();
        System.out.println(findLongestZigzag.longestZigZag(root));
    }
}
