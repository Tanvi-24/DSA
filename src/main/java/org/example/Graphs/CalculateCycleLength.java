package org.example.Graphs;
/*
    You are given an array of integers. Each element in the array points to the next index.
    You're asked to detect a cycle starting from a specific index and return its length.

    Start from startIndex, and keep moving to the next index based on value in arr[i].
    Maintain a visited[] array to track which indices you've already seen.
    If you revisit a visited index, that means a cycle is detected → return the cycle length.
    If you go out of bounds, that means no cycle → return -1.

    Method: findCycleLength(int[] arr, int startIndex)
    visited[]: boolean array to mark visited indices.
    Loop until the index is within bounds.
    If already visited → return cycleLength (cycle found).
    Else → mark visited, move to next index using arr[currentIndex].
    If loop ends without repeating → return -1.

    Time Complexity:
    O(N) – In worst case, we might visit all nodes once.
 */
public class CalculateCycleLength {

    public static int findCycleLength(int[] arr, int startIndex) {
        boolean[] visited = new boolean[arr.length];
        int currentIndex = startIndex;
        int cycleLength = 0;

        while (currentIndex >= 0 && currentIndex < arr.length) {
            // If we revisit the start index, a cycle is found
            if (visited[currentIndex]) {
                return cycleLength;
            }
            // Mark the current index as visited
            visited[currentIndex] = true;
            cycleLength++;
            currentIndex = arr[currentIndex];
        }

        // Return -1 if no cycle is found (out of bounds or other cases)
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {1,2,4,0};
        int a[] = {5, 6, 7, 8, 9,0};
        System.out.println("Length of cycle is " +findCycleLength(array,1));
        System.out.println("Length of cycle is "+findCycleLength(a,0));
    }
}
