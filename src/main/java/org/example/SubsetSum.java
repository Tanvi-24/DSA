package org.example;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static List<List<Integer>> findSubsetsWithSum(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        findSubsets(arr, targetSum, 0, currentSubset, result);
        return result;
    }

    private static void findSubsets(int[] arr, int targetSum, int currentIndex, List<Integer> currentSubset, List<List<Integer>> result) {
        if (currentIndex == arr.length) {
            if (targetSum == 0) {
                result.add(new ArrayList<>(currentSubset));
            }
            return;
        }

        // Include the current element in the subset
        currentSubset.add(arr[currentIndex]);
        findSubsets(arr, targetSum - arr[currentIndex], currentIndex + 1, currentSubset, result);

        // Exclude the current element from the subset
        currentSubset.remove(currentSubset.size() - 1);
        findSubsets(arr, targetSum, currentIndex + 1, currentSubset, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 8, 3};
        int targetSum = 7;

        List<List<Integer>> subsets = findSubsetsWithSum(arr, targetSum);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
