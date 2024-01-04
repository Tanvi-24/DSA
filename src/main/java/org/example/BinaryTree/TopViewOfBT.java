package org.example.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
