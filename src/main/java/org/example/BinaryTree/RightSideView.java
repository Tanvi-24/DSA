package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Problem:
    Binary Tree madhun right side view print karaycha aahe — mhanje tree chya pratyek level varun rightmost visible node.
    ✅ Logic:
    BFS (Level Order) traversal use kela aahe, pan right-to-left order ne.
    Queue (Info object) madhe node chi level (dis) ani node store karto.
    HashMap madhye first node (rightmost due to traversal order) for each level store karto using dis as key.
    info.node.right la pahile queue madhe add karto, mag info.node.left — so rightmost node pahila visit hoto.
    ✅ Step-by-step:
    Start with root node at level 0.
    For each node:
    If level not already in HashMap, add it (rightmost node for that level).
    Add right child first, then left child to the queue (right-first traversal).
    At the end, collect values from HashMap to form the right view.
    ✅ Complexity:
    Time: O(n) – Each node once visited.
    Space: O(n) – Queue + HashMap + Output List.
 */
public class RightSideView {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      public TreeNode(int val){
          this.val = val;
          this.right = null;
          this.left = null;
      }
  }

    class Info{
        int dis;
        TreeNode node;

        public Info(int dis, TreeNode node){
            this.dis = dis;
            this.node = node;
        }
    }

    public List<TreeNode> rightSideView(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<Integer,TreeNode> hashmap = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,root));

        while(!q.isEmpty()){
            Info info = q.remove();

            if(!hashmap.containsKey(Math.abs(info.dis))){
                hashmap.put(Math.abs(info.dis),info.node);
            }

            if(info.node.right != null){
                q.add(new Info(info.dis+1,info.node.right));
            }
            if(info.node.left != null){
                q.add(new Info(info.dis+1,info.node.left));
            }
        }

        /*for(Map.Entry<Integer,TreeNode> entry: hashmap.entrySet()){
            list.add(entry.getValue());
        }*/
        hashmap.forEach(list::add);

        return list;
    }

    public static void main(String[] args) {
        //1,2,3,null,4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        RightSideView rsv = new RightSideView();
        List<TreeNode> list = rsv.rightSideView(root);

        for(TreeNode t: list){
            System.out.println(t.val);
        }

    }
}
