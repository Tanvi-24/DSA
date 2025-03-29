package org.example.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    Problem:
    Binary tree cha structure ek String madhe convert karaycha (Serialize),
    ani tya String pasun tree parat construct karaycha (Deserialize).
    Logic for Serialization:
    Recursive preorder traversal vaprun each node cha value ek StringBuilder madhe store karto.
    Node null asel tar special marker ("null") append karto; jyamule structure accurately record hoto.
    Logic for Deserialization:
    Serialized String split karun queue madhe store karto.
    Recursive function (deserializeHelper) queue madhun values kadhtoy ani nodes create karto;
     "null" asel tar node null thevto.
    Complexity:
    Time: Serialize ani Deserialize donhi methods sathi O(n) (each node exactly once).
    Space: O(n) (queue ani recursion stack mule).
    Final output madhun verify karto ki serialized tree ani deserialized tree exactly same aahet.
 */

public class BinaryTreeSerialization {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // Serializes a binary tree to a string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserializes a string to a binary tree
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        BinaryTreeSerialization codec = new BinaryTreeSerialization();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized Tree: " + codec.serialize(deserialized));  // Should match the original serialization
    }
}

