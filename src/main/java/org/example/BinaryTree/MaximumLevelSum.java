package org.example.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Problem:
    Given a binary tree, find the level (1-based index) jithe nodes cha sum maximum aahe.
    ✅ Logic:
    BFS Traversal (Level Order):
    Queue (q) madhe nodes store kele aahet Info object madhe — jithe dis mhanje current level, and node mhanje TreeNode.
    HashMap madhye level wise node values cha sum maintain karto.
    Processing:
    Queue madhun node kadhun, tya node cha value hashmap madhye accumulate karto (using dis as key).
    Mag tyachya left ani right child la queue madhe add karto with level dis+1.
    Finding Max Sum Level:
    HashMap iterate karun maximum sum find karto ani tyacha level return karto (key + 1 because levels are 1-based).
    ✅ Complexity:
    Time: O(n) – each node once visit karto.
    Space: O(n) – HashMap ani Queue sathi.
    ✅ Output:
    Code maximum level sum calculate karun, kontya level var aahe te 1-based index return karto.
 */
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
