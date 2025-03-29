package org.example.BinaryTree;

/*
    Problem:
    Ek given Binary Tree madhla longest Zigzag path cha length find karaycha aahe.
    Zigzag path mhanje alternate left-right or right-left direction madhla path.
    Logic:
    Recursive method (zigzag) madhye, each node varun zigzag path track karto.
    Direction ani count maintain karun, jar direction change jhala tar count increment karto;
     nahi tar count reset karto.
    Global variable (maxCount) madhye maximum zigzag path length update karto.
    Implementation details:
    Initial root node pasun separately left ani right direction la call karto.
    Maximum count maintain karto ani final result return karto.
    Complexity:
    Time: O(n) (each node exactly once visit karto)
    Space: O(h) (recursion stack mule)
    Final madhye longest zigzag path cha length print karto.
 */
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
