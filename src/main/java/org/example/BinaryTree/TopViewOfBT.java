package org.example.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*
    Problem:
    Binary Tree madhun top view print karaycha aahe — mhanje tree la top side ne pahilat tar pratek horizontal line var distoy to node.
    ✅ Logic:
    Horizontal Distance (HD) Concept:
    Root node la HD = 0.
    Left child la HD - 1, right child la HD + 1.
    Approach:
    BFS (level order) traversal use kela aahe using a queue (Info object containing node + its HD).
    HashMap madhe pratek unique HD sathi first visible node store karto (topmost at that HD).
    BFS madhe left child la HD -1, right child la HD +1 gheun queue madhe add karto.
    min ani max track karto to print final output from leftmost to rightmost.
    Print:
    HashMap madhun min to max HD range loop karun top view print karto.
    ✅ Complexity:
    Time: O(n) — every node visit hotoy once
    Space: O(n) — HashMap + Queue usage
    ✅ Output:
    topView() function tree cha top view (first visible nodes per horizontal level) console var print karto.
    Example output for given tree: 4 2 1 3 7
 */

public class TopViewOfBT {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class Info{
        Node node;
        int horizontal_dis;

        public Info(Node node, int horizontal_dis){
            this.node = node;
            this.horizontal_dis = horizontal_dis;
        }
    }

    public void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int min=0,max=0;
        Info info = new Info(root,0);
        q.add(info);
        q.add(null);

        while (!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty())
                    break;
                else {
                    q.add(null);
                }
            }
            else {
                if (!map.containsKey(curr.horizontal_dis)) {
                    map.put(curr.horizontal_dis, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.horizontal_dis - 1));
                    min = Math.min(min, curr.horizontal_dis - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.horizontal_dis + 1));
                    max = Math.max(max, curr.horizontal_dis + 1);
                }
            }

        }

        for (int i=min;i<=max;i++){
            System.out.print(map.get(i).data+ " ");
        }

    }
    public static void main(String[] args) {
        TopViewOfBT topViewOfBT = new TopViewOfBT();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left =  new Node(6);
        root.right.right = new Node(7);
        topViewOfBT.topView(root);
    }


}
