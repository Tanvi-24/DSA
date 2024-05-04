package org.example.DESHAW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplications {
    public static List<Integer> duplicates(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        // Count the frequency of each element
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Check for elements with frequency greater than 1 (duplicates)
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 1, 3, 6, 6};

        List<Integer> ans = duplicates(arr);
        if (ans.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("The repeating elements are:");
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
}

