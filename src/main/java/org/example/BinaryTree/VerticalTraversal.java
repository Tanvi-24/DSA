package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
    Problem:
    Given a Binary Tree, perform a vertical traversal jithe:
    Nodes group kele astat by vertical columns (horizontal distance),
    Same level che nodes sorted in ascending order.
    ✅ Logic:
    Traversal Strategy:
    BFS (Level Order) using a Queue<Info> je node cha horizontal distance (hd) ani level maintain karto.
    TreeMap use kelay to auto-sort horizontal distances.
    Map Structure:
    Map<Integer, List<Pair>>
    Key = horizontal distance (column),
    Value = list of (node value, level).
    Sorting Rule:
    Nodes sorted by level (top to bottom),
    If level same → sort by node value (ascending).
    Data Structures:
    Info → stores node, horizontal distance, and level.
    Pair → stores node value and its level.
    Final Step:
    For each horizontal distance in sorted order (TreeMap),
    Extract node values from sorted Pair list and prepare result list.
    ✅ Complexity:
    Time: O(n log n) due to sorting inside map values.
    Space: O(n) for map and queue.
    ✅ Output:
    Main method madhe vertical order traversal perform karto,
    ani pratek column-wise nodes print karto — sorted as per level & value
 */
/*
vertical traversal such that the nodes belonging to same column, should be sorted according to level in increasing order
 and values with same level should be sorted in ascending order
*/
public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(Node root) {
        Map<Integer, List<Pair>> map = new TreeMap<>();
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(root, 0, 1));
        while (!queue.isEmpty()) {
            Info info = queue.poll();
            if (!map.containsKey(info.horizontal_dis)) {
                map.put(info.horizontal_dis, new ArrayList<>());
                map.get(info.horizontal_dis).add(new Pair(info.node.val, info.level));
            } else {
                List<Pair> list = map.get(info.horizontal_dis);
                list.add(new Pair(info.node.val, info.level));
                /*here if the levels are different then they are sorted in increasing order of level and
                 if the levels are same they are sorted in ascending order*/
                Collections.sort(list, (p1, p2) ->{
                    if(p1.value == p2.value){
                        return p1.key- p2.key;
                    }
                    return p1.value - p2.value;
                });
                map.put(info.horizontal_dis, list);
            }
            if (info.node.left != null) {
                queue.offer(new Info(info.node.left, info.horizontal_dis - 1, info.level + 1));
            }
            if (info.node.right != null) {
                queue.offer(new Info(info.node.right, info.horizontal_dis + 1, info.level + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            List<Pair> pairList = entry.getValue();
            List<Integer> keys = new ArrayList<>();
            for (Pair pair : pairList) {
                keys.add(pair.key);
            }
            result.add(keys);
        }

        return result;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        Node node;
        int horizontal_dis;
        int level;

        public Info(Node node, int horizontal_dis, int level) {
            this.node = node;
            this.horizontal_dis = horizontal_dis;
            this.level = level;
        }
    }

    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        VerticalTraversal verticalTraversal = new VerticalTraversal();
        List<List<Integer>> result = verticalTraversal.verticalTraversal(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}