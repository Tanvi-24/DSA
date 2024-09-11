package org.example.goldmanSachs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLargestRoot {

    public static int getLargestRoot(Map<Integer,Integer> childToParent){

        Map<Integer,Integer> parentChildCount = new HashMap<>();
        for(Map.Entry<Integer,Integer> tree:childToParent.entrySet()){
            if(parentChildCount.containsKey(tree.getValue())){
                parentChildCount.put(tree.getValue(),parentChildCount.get(tree.getValue())+1);
            }
            else{
                int treeKey = tree.getValue();
                if(childToParent.containsKey(treeKey)){
                    while(childToParent.containsKey(treeKey)) {
                        int key = childToParent.get(tree.getValue());
                        parentChildCount.put(childToParent.get(tree.getValue()), parentChildCount.get(key) + 1);
                    }
                }
                else {
                    parentChildCount.put(tree.getValue(), 1);
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        int root=0;
        for(Map.Entry<Integer,Integer> map:parentChildCount.entrySet()){
            if(map.getValue() == maxVal){
                root = Math.min(map.getKey(),root);
            }
            else if(map.getValue()>maxVal){
                maxVal = map.getValue();
                root = map.getKey();
            }
        }
        return root;
    }
    public static int findLargestTreeRoot(Map<Integer, Integer> childParentMap) {
        Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>(childParentMap.keySet());

        // Step 1: Build parent-children map
        for (Map.Entry<Integer, Integer> entry : childParentMap.entrySet()) {
            int child = entry.getKey();
            int parent = entry.getValue();
            parentToChildren.putIfAbsent(parent, new HashSet<>());
            parentToChildren.get(parent).add(child);
            allNodes.add(parent);
        }

        // Step 2: Find the root nodes
        Set<Integer> rootCandidates = new HashSet<>(allNodes);
        rootCandidates.removeAll(childParentMap.keySet());

        int largestTreeRoot = -1;
        int maxSize = 0;

        // Step 3: For each root candidate, find the size of its tree using DFS
        for (int root : rootCandidates) {
            int treeSize = dfs(root, parentToChildren);
            if (treeSize > maxSize || (treeSize == maxSize && root < largestTreeRoot)) {
                maxSize = treeSize;
                largestTreeRoot = root;
            }
        }
        return largestTreeRoot;
    }

    // Helper function: Depth First Search (DFS) to calculate tree size
    private static int dfs(int node, Map<Integer, Set<Integer>> parentToChildren) {
        if (!parentToChildren.containsKey(node)) return 1;
        int size = 1;
        for (int child : parentToChildren.get(node)) {
            size += dfs(child, parentToChildren);
        }
        return size;
    }
    public static void main(String[] args) {
        Map<Integer,Integer> childToParent = new HashMap<>();
        childToParent.put(5,1);
        childToParent.put(1,2);
        childToParent.put(3,4);
        childToParent.put(11,3);
        childToParent.put(7,11);
        System.out.println(findLargestTreeRoot(childToParent));
    }
}
