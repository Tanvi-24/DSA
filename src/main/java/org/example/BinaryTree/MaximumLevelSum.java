package org.example.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSum {
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
    static class Info{
        int dis;
        TreeNode node;

        public Info(int dis, TreeNode node){
            this.dis = dis;
            this.node = node;
        }
    }
    public int maxLevelSum(TreeNode root) {

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,root));

        HashMap<Integer,Integer> hashmap = new HashMap<>();

        while(!q.isEmpty()){
            Info info = q.remove();

            if(info.node!=null){
                if(!hashmap.containsKey(Math.abs(info.dis)))
                {
                    hashmap.put(info.dis,info.node.val);
                }
                else{
                    hashmap.put(info.dis, hashmap.get(info.dis)+info.node.val);
                }
            }

            if(info.node !=null && info.node.left != null){
                q.add(new Info(info.dis+1,info.node.left));
            }
            if(info.node !=null && info.node.right != null){
                q.add(new Info(info.dis+1,info.node.right));
            }
        }
        int max =0,key=0;
        for(Map.Entry<Integer,Integer> map: hashmap.entrySet()){
            if(map.getValue()>max){
                max = map.getValue();
                key = map.getKey();
            }
        }

        return key+1;
    }

    public static void main(String[] args) {
        //[989,null,10250,98693,-89388,null,null,null,-32127]
        TreeNode root = new TreeNode(989);
        root.right = new TreeNode(10250);
        root.right.left = new TreeNode(98693);
        root.right.right =new TreeNode(-89388);
        root.right.right.right =new TreeNode(-32127);

        MaximumLevelSum mx = new MaximumLevelSum();
        System.out.println(mx.maxLevelSum(root));

    }
}
