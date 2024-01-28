package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
        for(Map.Entry<Integer,TreeNode> entry: hashmap.entrySet()){
            list.add(entry.getValue());
        }
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
