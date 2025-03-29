package org.example.BinarySearchTree;

import java.lang.*;
import java.util.*;

/*
    Problem: Given a Binary Tree where every node has pointers: left, right,
    and special random pointer pointing to any node in the tree or null.
    You need to create an exact clone (duplicate) of this binary tree.
    Solution approach:
    Clone left-right pointers (clonelr()):
    Using recursion, create a new tree and clone all left-right nodes.
    A HashMap stores the mapping between original and cloned nodes.
    Clone random pointers (copyrandom()):
    After cloning left-right pointers, again recursively set the random pointers in
    cloned tree using HashMap references.
    HashMap ensures original tree node ani cloned tree node madhe mapping maintain kartoy,
    jyamule random pointers efficiently set karayla help hote.
    Final madhye, original ani cloned tree cha inorder traversal print kela aahe,
    verifying ki clone exactly original sarkha zalay ka.
    Complexity:
    Time: O(n) (each node visited exactly twice)
    Space: O(n) (due to HashMap ani recursion stack space)
 */
class Tree {
    int data;
    Tree left, right, random;

    Tree(int d)
    {
        data = d;
        left = null;
        right = null;
        random = null;
    }
}

public class CloneABT {
    public static void main(String[] args)
    {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.random = tree.left.right;
        tree.left.left.random = tree;
        tree.left.right.random = tree.right;

        System.out.println(
                "Inorder traversal of original binary tree is: \n");
        printInorder(tree);

        Tree clone = cloneTree(tree);

        System.out.println(
                "\n\nInorder traversal of cloned binary tree is: \n");
        printInorder(clone);
    }
    public static Tree cloneTree(Tree tree)
    {
        if (tree == null)
            return null;
        HashMap<Tree, Tree> map
                = new HashMap<>(); // create a hashmap to store
        // the randoms
        Tree newtree = clonelr(tree, map);
        copyrandom(tree, newtree, map);
        return newtree;
    }

    // cloning the left and right tree
    public static Tree clonelr(Tree tree,
                               HashMap<Tree, Tree> map)
    {
        if (tree == null)
            return null;
        Tree clonenode = new Tree(tree.data);
        map.put(tree, clonenode);
        clonenode.left = clonelr(tree.left, map);
        clonenode.right = clonelr(tree.right, map);
        return clonenode;
    }

    // setting the random pointers in the cloned tree
    public static void copyrandom(Tree tree, Tree clone,
                                  HashMap<Tree, Tree> map)
    {
        if (clone == null)
            return;
        clone.random = map.get(tree.random);
        copyrandom(tree.left, clone.left, map);
        copyrandom(tree.right, clone.right, map);
    }

    static void printInorder(Tree node)
    {
        if (node == null)
            return;

        /* First recur on left subtree */
        printInorder(node.left);

        /* then print data of Node and its random */
        System.out.print("[" + node.data + " ");
        if (node.random == null)
            System.out.print("null], ");
        else
            System.out.print(node.data + "]");
        /* now recur on right subtree */
        printInorder(node.right);
    }

    public static boolean printInorder(Tree a, Tree b)
    {
        if ((a == null) && (b == null))
            return true;
        if (a != null && b != null) {
            boolean check
                    = ((a.data == b.data)
                    && printInorder(a.left, b.left)
                    && printInorder(a.right, b.right));
            if (a.random != null && b.random != null)
                return (
                        check
                                && (a.random.data == b.random.data));
            if (a.random == b.random)
                return check;
            return false;
        }
        return false;
    }

    public static void clone(Tree root, Tree proot, int n1,
                             int n2)
    {
        try {
            if (root == null && proot == null)
                return;
            if (n1 == root.data) {
                if (proot.data == n2)
                    root.random = proot;
                else {
                    clone(root, proot.left, n1, n2);
                    clone(root, proot.right, n1, n2);
                }
            }
            else {
                clone(root.left, proot, n1, n2);
                clone(root.right, proot, n1, n2);
            }
        }
        catch (NullPointerException ex) {
        }
    }

    public static void insert(Tree root, int n1, int n2,
                              char lr)
    {
        if (root == null)
            return;
        if (n1 == root.data) {
            switch (lr) {
                case 'L':
                    root.left = new Tree(n2);
                    break;
                case 'R':
                    root.right = new Tree(n2);
                    break;
            }
        }
        else {
            insert(root.left, n1, n2, lr);
            insert(root.right, n1, n2, lr);
        }
    }
}

