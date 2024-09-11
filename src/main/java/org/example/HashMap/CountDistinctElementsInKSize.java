package org.example.HashMap;
//CountDistinctElementsInKSize
import java.util.HashMap;

public class CountDistinctElementsInKSize {
    public static void countDistinctInWindow(int[] arr, int K) {
        // HashMap to store the frequency of elements in the current window
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Initialize the map for the first window of size K
        for (int i = 0; i < K; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        // Print distinct count for the first window
        System.out.println("Distinct elements in window: " + frequencyMap.size());

        // Traverse the rest of the array
        for (int i = K; i < arr.length; i++) {
            // Remove the element going out of the window
            int outgoingElement = arr[i - K];
            if (frequencyMap.get(outgoingElement) == 1) {
                frequencyMap.remove(outgoingElement);
            } else {
                frequencyMap.put(outgoingElement, frequencyMap.get(outgoingElement) - 1);
            }

            // Add the new element in the current window
            int incomingElement = arr[i];
            frequencyMap.put(incomingElement, frequencyMap.getOrDefault(incomingElement, 0) + 1);

            // Print distinct count for the current window
            System.out.println("Distinct elements in window: " + frequencyMap.size());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int K = 4;
        countDistinctInWindow(arr, K);
    }
}

